package com.example.jwtservice.util;

import java.util.Date;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("mySuperSecureKey12345678901234567890".getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1200000)) // 20 min
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact();
    }
}

