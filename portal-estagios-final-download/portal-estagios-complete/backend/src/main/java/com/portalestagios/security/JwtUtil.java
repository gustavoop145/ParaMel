package com.portalestagios.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    // NOTE: In production store secret securely; here it's hard-coded for scaffold simplicity
    private final Key key = Keys.hmacShaKeyFor(System.getenv().getOrDefault("SPRING_JWT_SECRET","changeit-changeit-changeit-changeit-12345").getBytes());
    private final long expiration = 1000L * 60 * 60 * 24; // 24h

    public String generateToken(String subject) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + expiration))
                .signWith(key)
                .compact();
    }

    public String extractSubject(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token).getBody().getSubject();
        } catch (JwtException e) {
            return null;
        }
    }
}
