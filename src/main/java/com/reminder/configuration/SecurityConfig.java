package com.reminder.configuration;

import com.reminder.component.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private JwtUtility jwtUtility;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(o -> o.requestMatchers("/user/register").permitAll()
                        .requestMatchers("/test").permitAll()
                                .anyRequest().permitAll()
//                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(form -> form.defaultSuccessUrl("/",true))
                .httpBasic(Customizer.withDefaults())
                .build();
    }



//    @Bean
//    public JwtAuthenticationConverter jwtAuthenticationConverter() {
//        return new JwtAuthenticationConverter();
//    }
//
//    private static final String JWKS_URI = "https://www.googleapis.com/oauth2/v3/certs"; // Use your OAuth2 provider's JWKS URI
//
//    @Bean
//    public JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withJwkSetUri(JWKS_URI).build();
//    }
}
