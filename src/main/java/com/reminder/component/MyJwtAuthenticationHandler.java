//package com.expensetracker.component;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class MyJwtAuthenticationHandler implements AuthenticationSuccessHandler {
//
//    private JwtUtility jwtUtility;
//
//
//    public MyJwtAuthenticationHandler(JwtUtility jwtUtility) {
//        this.jwtUtility = jwtUtility;
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
//        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//
//        // Extract user details
//        String email = oAuth2User.getAttribute("email");
//
//        // Generate JWT Token
//        String token = jwtUtility.generateToken(email);
//
//        // Store JWT in a cookie (Optional)
//        Cookie jwtCookie = new Cookie("JWT-TOKEN", token);
//        jwtCookie.setHttpOnly(true);
//        jwtCookie.setSecure(true);
////        jwtCookie.setPath("/");
//        response.addCookie(jwtCookie);
//        response.setContentType("application/json"); // Set JSON response type
//        response.setHeader("Authorization", "Bearer " + token); // Set header
//
//        // Write JSON response
//        response.getWriter().write("{\"token\": \"Bearer " + token + "\"}");
//
//        // Retrieve the original requested URL before authentication (if exists)
////        String targetUrl = (String) request.getSession().getAttribute("REDIRECT_URL");
////
////        if (targetUrl == null || targetUrl.isEmpty()) {
////            targetUrl = "http://localhost:8080/"; // Default redirect URL
////        }
////
////        response.sendRedirect(targetUrl);
//    }
//}
