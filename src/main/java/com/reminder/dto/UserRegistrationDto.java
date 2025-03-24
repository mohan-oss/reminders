package com.reminder.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserRegistrationDto {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    @Builder.Default
    private boolean isActive = true;
}
