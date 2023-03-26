package com.example.project.security;

import com.example.project.model.UserModel;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Date;

public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private String jwtSecret = "";
    private int jwtExpirationTime = 30;
    private final static String ID = "id";

    public JwtUtils() {
    }

    public String generateJwtToken(UserModel userEntity) {
        Date now = new Date();
        return Jwts.builder()
                .setSubject(userEntity.getEmail())
                .claim(ID, userEntity.getId())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtExpirationTime))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

    public UserDetails extractDetails(String token) {
        Claims body = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        int id = body.get(ID, Integer.class);
        String email = body.getSubject();
        return new UserDetailsImplementation(id, email);
    }

    private class UserDetailsImplementation implements UserDetails{

        private final int id;
        private final String email;

        private UserDetailsImplementation(int id, String email) {
            this.id = id;
            this.email = email;
        }


        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return null;
        }

        @Override
        public String getUsername() {
            return null;
        }

        @Override
        public boolean isAccountNonExpired() {
            return false;
        }

        @Override
        public boolean isAccountNonLocked() {
            return false;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return false;
        }

        @Override
        public boolean isEnabled() {
            return false;
        }
    }
}
