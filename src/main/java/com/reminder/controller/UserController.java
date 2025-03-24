package com.reminder.controller;

import com.reminder.dto.UserRegistrationDto;
import com.reminder.service.user.ExpenseUserDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Slf4j
public class UserController {
    private ExpenseUserDetailsService userDetailsService;
    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@Valid @RequestBody UserRegistrationDto userRegistrationDto){
        log.info("registerUser called - {} ", userRegistrationDto);
        return userDetailsService.registerUser(userRegistrationDto);
    }
}
