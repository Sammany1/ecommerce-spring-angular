package com.example.ecommerceapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class JwtTokenService {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenService.class);
    private static final Key SIGNING_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    private static final long EXPIRATION_TIME = 86400000; // 1 day in milliseconds

    public String generateToken(Authentication authentication) {
        logger.debug("Entering generateToken method with username: {}", authentication.getName());
        String token = null;
        try {
            if (authentication == null || authentication.getAuthorities() == null || authentication.getAuthorities().isEmpty()) {
                throw new NoSuchElementException("No authorities found for User");
            }
            String role = "ROLE_" + authentication.getAuthorities().iterator().next().getAuthority();
            token = Jwts.builder()
                    .setSubject(authentication.getName())
                    .claim("role", role)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                    .signWith(SIGNING_KEY, SignatureAlgorithm.HS512)
                    .compact();
            logger.debug("Generated token: {}", token);
        } catch (NoSuchElementException e) {
            logger.error("No authorities found for user", e);
        } catch (Exception e) {
            logger.error("Error generating JWT token", e);
        }
        logger.debug("Exiting generateToken method with token: {}", token);
        return token;
    }

    public Authentication getTokenAuthentication(String token) {
        logger.debug("Entering getAuthentication method with token: {}", token);
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        String username = claims.getSubject();
        String role = claims.get("role", String.class);
        if (username != null && role != null) {
            logger.debug("Exiting getAuthentication method with username: {}", username);
            return new UsernamePasswordAuthenticationToken(username, null, Collections.singletonList(new SimpleGrantedAuthority(role)));
        }
        logger.debug("Exiting getAuthentication method with null username");
        return null;
    }
}