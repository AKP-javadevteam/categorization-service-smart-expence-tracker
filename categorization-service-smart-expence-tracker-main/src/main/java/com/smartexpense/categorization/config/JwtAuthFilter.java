package com.smartexpense.categorization.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    @Value("${security.jwt.algorithm:HS256}") private String alg;
    @Value("${security.jwt.hmacSecret:dev-local-secret}") private String secret;
    @Value("${security.jwt.issuer}") private String issuer;
    @Value("${security.jwt.audience}") private String audience;
    @Value("${security.jwt.required-role}") private String requiredRole;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException
}
