package com.authentication.authentication.Security;

import com.authentication.authentication.Entity.Role;
import com.authentication.authentication.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Getter
@Setter
public class JWTService {

    private final SecretKey key;
    private final long accessTtlSeconds;
    private final long refreshTtlSeconds;
    private final String issuer;

    public JWTService(
            @Value("${security.jwt.secret}") String secret,
            @Value("${security.jwt.access-ttl-seconds}") long accessTtlSeconds,
            @Value("${security.jwt.refresh-ttl-seconds}") long refreshTtlSeconds,
            @Value("${security.jwt.issuer}") String issuer
    ) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessTtlSeconds = accessTtlSeconds;
        this.refreshTtlSeconds = refreshTtlSeconds;
        this.issuer = issuer;
    }


    //Generate token
    public String generateToken(User user) {

        Instant now = Instant.now();
        List<String> roles = user.getRoles()==null? List.of() : user.getRoles().stream().map(Role::getName).toList();
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .subject(user.getId().toString())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(accessTtlSeconds)))
                .claims(Map.of(
                        "email", user.getEmail(),
                        "roles", roles,
                        "type","access"
                ))
                .signWith(key)
                .compact();
    }

    // Generate refresh token
    public String generateRefreshToken(User user,String rTId) {

        Instant now = Instant.now();

        return Jwts.builder()
                .id(rTId)
                .subject(user.getId().toString())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plusSeconds(refreshTtlSeconds)))
                .claim(
                        "type", "refresh"
                )
                .signWith(key)
                .compact();
    }

    public Jws<Claims> parse(String tocken){
        try{
            return Jwts.parser().verifyWith(key).build().parseSignedClaims(tocken);
        }
        catch(JwtException e){
            throw e;
        }
    }

    public boolean isAccessToken(String token){
        Claims c=parse(token).getPayload();
        return "access".equals(c.get("type"));
    }

    public boolean isRefreshToken(String token){
        Claims c=parse(token).getPayload();
        return "refresh".equals(c.get("type"));
    }

    public UUID getUserId(String token){
        Claims c=parse(token).getPayload();
        return UUID.fromString(c.getSubject());
    }

    public String getJti(String token){
            return parse(token).getPayload().getId();
    }
}