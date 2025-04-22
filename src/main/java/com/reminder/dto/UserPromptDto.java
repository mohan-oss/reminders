package com.reminder.dto;

import com.reminder.entity.app.CommonPromptTailors;
import com.reminder.entity.app.UserTailor;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserPromptDto {
    @NotBlank
    private String promptText;
    private List<UserTailor> userTailors;
    private List<CommonPromptTailors> commonTailors;
}
