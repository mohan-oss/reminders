//package com.expensetracker.component;
//
//import io.jsonwebtoken.Claims;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//@Slf4j
//public class MyJwtSecurityFilterChain extends OncePerRequestFilter {
//
//
//    private JwtUtility jwtUtility;
//
//    public MyJwtSecurityFilterChain(JwtUtility jwtUtility) {
//        this.jwtUtility = jwtUtility;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        try {
//            String authHeader = request.getHeader("Authorization");
//            if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                String token = authHeader.substring(7);
//                System.out.println("Token: " + token);
//
//                if (jwtUtility.validateToken(token)) {
//                    Claims body = jwtUtility.extractClaims(token);
//                    List<String> roles = body.get("roles", List.class); // ✅ Proper extraction
//                    System.out.println("User: " + body.getSubject());
//
//                    Authentication authentication = new UsernamePasswordAuthenticationToken(
//                            body.getSubject(),
//                            null,
//                            roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
//                    );
//
//                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
//            }
//        } catch (Exception e) {
//            log.error("JWT Processing Error: ", e);
//        }
//        chain.doFilter(request, response); // ✅ Always continue the filter chain
//    }
//}
