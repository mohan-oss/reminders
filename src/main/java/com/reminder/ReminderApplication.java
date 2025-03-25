package com.reminder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication()
@EnableScheduling
@EnableJpaAuditing
@Slf4j
public class ReminderApplication implements CommandLineRunner {
	@Autowired Environment environment;

	public static void main(String[] args) {
//		SpringApplication.run(ExpensetrackerApplication.class, args);
		SpringApplication app = new SpringApplication(ReminderApplication.class);
		// Set active profiles programmatically
		app.setAdditionalProfiles("dev");  // Set active profile to "dev"
		app.run(args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Arrays.toString(environment.getActiveProfiles()));
	}

//	@Scheduled(cron = "0 * * * * *")
	public void printHello(){
		log.info("Scheduled print {}", LocalDateTime.now());
	}
}
