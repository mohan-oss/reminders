package com.reminder.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class CommonConfig {

    @Bean
    public AuditorAware<String> getAuditName(){
        return ()->Optional.of("Mohan");
    }
}
