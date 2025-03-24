package com.reminder.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtility {

    private static final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret-your-256-bit-secret"; // Must be Base64 or at least 32 bytes

    private final SecretKey key;

    public JwtUtility() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // Use getBytes() if it's plain text
    }

    public String generateToken(String username) {
        List<String> role = List.of("user");
        if(username.equals("mohansurendar.mullapudi@gmail.com")){
            role = List.of("admin");
        }
        return Jwts.builder()
                .subject(username) // ✅ Correct method
                .issuedAt(new Date())
                .claim("roles", role)
                .expiration(new Date(System.currentTimeMillis() + Duration.ofHours(8).toMillis()))
                .signWith(key, SignatureAlgorithm.HS256) // ✅ Correct signing method
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser() // ✅ Use parserBuilder() instead of parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = extractClaims(token);
            Date expiration = claims.getExpiration();
            return expiration.after(new Date()); // Token is valid if it's not expired
        } catch (Exception e) {
            return false; // Token is invalid
        }
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}
