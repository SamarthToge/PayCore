package com.authentication.authentication.Controllers;

import com.authentication.authentication.DTOs.LoginRequest;
import com.authentication.authentication.DTOs.RefreshTokenRequest;
import com.authentication.authentication.DTOs.TokenResponse;
import com.authentication.authentication.DTOs.UserDTO;
import com.authentication.authentication.Entity.RefreshToken;
import com.authentication.authentication.Entity.User;
import com.authentication.authentication.Repository.RefreshTokenRRepository;
import com.authentication.authentication.Repository.UserRepository;
import com.authentication.authentication.Security.CookieService;
import com.authentication.authentication.Security.JWTService;
import com.authentication.authentication.Services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final ModelMapper rowMapper;
    private final RefreshTokenRRepository refreshTokenRRepository;
    private final CookieService cookieService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse){
       Authentication authentication= authenticate(loginRequest);
       User user=userRepository.findByEmail(loginRequest.email()).orElseThrow(()->new BadCredentialsException("Invalid Username or Password"));
       if(!user.isEnabled()){
            throw new DisabledException("User is disabled");
       }

       String jti= UUID.randomUUID().toString();
       var refreshTokenobj = RefreshToken.builder().
               jti(jti)
               .user(user)
               .createdAt(Instant.now())
               .expiredAt(Instant.now().plusSeconds(jwtService.getRefreshTtlSeconds()))
               .revoked(false)
               .build();

        refreshTokenRRepository.save(refreshTokenobj);

       String accessToken=jwtService.generateToken(user);
       String refreshToken=jwtService.generateRefreshToken(user,refreshTokenobj.getJti());

       cookieService.attachRefreshCookie(httpServletResponse,refreshToken,(int) jwtService.getRefreshTtlSeconds());
       cookieService.addNoStoreHeader(httpServletResponse);

       TokenResponse tokenResponse= TokenResponse.of(accessToken,"",jwtService.getAccessTtlSeconds(),rowMapper.map(user,UserDTO.class));
        return ResponseEntity
                .ok()
                .body(tokenResponse);
    }

    private Authentication authenticate(LoginRequest loginRequest){

        try{
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.email(),loginRequest.password()));
        }
        catch (Exception e){
            throw new BadCredentialsException("Invalid username or Password");
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refreshToken(@RequestBody(required = false) RefreshTokenRequest body, HttpServletResponse resonse, HttpServletRequest request){
              String refreshToken = readRefreshTokenFromRequest(body,request).orElseThrow(() -> new BadCredentialsException("Refresh token is missing"));

              if(!jwtService.isRefreshToken(refreshToken)){
                  throw new BadCredentialsException("Invalid refresh token");
              }

              String jti= jwtService.getJti(refreshToken);
              UUID userId=jwtService.getUserId(refreshToken);
              RefreshToken storedRefreshToken= refreshTokenRRepository.findByJti(jti).orElseThrow(()->new BadCredentialsException("Refresh token not found"));

              if(storedRefreshToken.isRevoked()){
                  throw  new BadCredentialsException("Refresh token is revoked");
              }

              if(storedRefreshToken.getExpiredAt().isBefore(Instant.now())){
                  throw new BadCredentialsException("Refresh token is expired");
              }

              if(!storedRefreshToken.getUser().getId().equals(userId)){
                  throw new BadCredentialsException("Refresh token does not belong to this User");
              }

              storedRefreshToken.setRevoked(true);
              String newJti=UUID.randomUUID().toString();
              storedRefreshToken.setReplacedByToken(newJti);
              refreshTokenRRepository.save(storedRefreshToken);
              User user=storedRefreshToken.getUser();
              var newRefreshTokenObj = RefreshToken.builder()
                      .jti(newJti)
                      .user(user)
                      .createdAt(Instant.now())
                      .expiredAt(Instant.now().plusSeconds(jwtService.getRefreshTtlSeconds()))
                      .revoked(false)
                      .build();
              refreshTokenRRepository.save(newRefreshTokenObj);
              String newAccesToken=jwtService.generateToken(user);
              String newRefreshToken= jwtService.generateRefreshToken(user,newRefreshTokenObj.getJti());
              cookieService.attachRefreshCookie(resonse,newRefreshToken,(int) jwtService.getRefreshTtlSeconds());
              cookieService.addNoStoreHeader(resonse);
              return ResponseEntity.ok(TokenResponse.of(newAccesToken,newRefreshToken,jwtService.getAccessTtlSeconds(),rowMapper.map(user,UserDTO.class)));
    }

    private Optional<String> readRefreshTokenFromRequest(
            RefreshTokenRequest body,
            HttpServletRequest request
    ) {

        // 1. Cookie
        if (request.getCookies() != null) {

            Optional<String> fromCookie = Arrays.stream(request.getCookies())
                    .filter(c -> cookieService.getRefreshTokenCookieName().equals(c.getName()))
                    .map(Cookie::getValue)
                    .filter(v -> !v.isBlank())
                    .findFirst();

            if (fromCookie.isPresent()) {
                return fromCookie;
            }
        }

        // 2. Request body
        if (body != null &&
                body.refreshToken() != null &&
                !body.refreshToken().isBlank()) {

            return Optional.of(body.refreshToken());
        }

        // 3. X-Refresh-Token header
        String refreshHeader = request.getHeader("X-Refresh-Token");

        if (refreshHeader != null && !refreshHeader.isBlank()) {
            return Optional.of(refreshHeader.trim());
        }

        // 4. Authorization: Bearer <refresh-token>
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null &&
                authHeader.regionMatches(true, 0, "Bearer ", 0, 7)) {

            String token = authHeader.substring(7).trim();

            if (!token.isBlank()) {
                return Optional.of(token);
            }
        }

        return Optional.empty();
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout(
            HttpServletRequest request,
            HttpServletResponse response
    ) {

        Optional<String> refreshToken = readRefreshTokenFromRequest(null, request);

        if (refreshToken.isPresent()) {

            String token = refreshToken.get();

            if (jwtService.isRefreshToken(token)) {

                String jti = jwtService.getJti(token);

                refreshTokenRRepository.findByJti(jti)
                        .ifPresent(storedRefreshToken -> {

                            storedRefreshToken.setRevoked(true);

                            refreshTokenRRepository.save(storedRefreshToken);
                        });
            }
        }

        cookieService.clearRefreshCookie(response);

        cookieService.addNoStoreHeader(response);

        return ResponseEntity.noContent().build();
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.regUser(userDTO));
    }
}