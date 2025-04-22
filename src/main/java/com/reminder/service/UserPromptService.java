package com.reminder.service;

import com.reminder.dto.UserPromptDto;
import com.reminder.entity.app.UserPrompt;

public interface UserPromptService {
    public UserPrompt saveUserPrompt(UserPromptDto userPromptDto);
}
