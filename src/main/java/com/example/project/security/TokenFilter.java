package com.example.project.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class TokenFilter extends BasicAuthenticationFilter {
    private final JwtUtils jwtUtils;

    public TokenFilter(AuthenticationManager authManager, JwtUtils jwtUtils) {
        super(authManager);
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = extractJwt(request);
        if (jwt != null && jwtUtils.validateJwtToken(jwt)) {

            UserDetails userDetails = jwtUtils.extractDetails(jwt);
            SecurityContextHolder.getContext().setAuthentication(map(userDetails));

        }
        filterChain.doFilter(request, response);
    }

    private String extractJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            String[] jwtSplit = headerAuth.split(" ");
            return jwtSplit[1];
        }
        return null;
    }

    private Authentication map(UserDetails userDetails) {
        return new JwtToken(userDetails);}
}
