package com.reminder.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetRemaindersRequestDto {
    @NotBlank
    private String userId;
    private int pageSize;
    private int pageNumber;
}
