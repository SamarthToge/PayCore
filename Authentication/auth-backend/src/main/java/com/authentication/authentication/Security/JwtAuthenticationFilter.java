package com.authentication.authentication.Security;

import com.authentication.authentication.Repository.UserRepository;
import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (jwtService.isAccessToken(token)) {
                try {
                    Jws<Claims> parse = jwtService.parse(token);
                    Claims payload = parse.getPayload();
                    String userId = payload.getSubject();
                    UUID userUuid = UUID.fromString(userId);

                    userRepository.findById(userUuid)
                            .ifPresent(user -> {
                                    if (user.isEnabled()) {
                                    List<GrantedAuthority> authorities = user.getRoles() == null ? List.of() : user.getRoles().stream()
                                            .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
                                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                            user, null, authorities
                                    );

                                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                                        SecurityContextHolder.getContext().setAuthentication(authentication);
                                    }
                                }
                            });
                } catch (JwtException e) {
                    // Let security context remain unauthenticated
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        filterChain.doFilter(request, response);
    }

    @Override
    public boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        return request.getRequestURI().startsWith("/api/v1/auth/");
    }
}
