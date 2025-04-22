package com.reminder.serviceimpl;


import com.reminder.dao.app.UserPromptsRepo;
import com.reminder.dto.UserPromptDto;
import com.reminder.entity.app.UserPrompt;
import com.reminder.service.UserPromptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserPromptServiceImpl implements UserPromptService {
    private UserPromptsRepo userPromptsRepo;
    @Override
    public UserPrompt saveUserPrompt(UserPromptDto userPromptDto) {
        UserPrompt userPrompt = UserPrompt.builder().prompt(userPromptDto.getPromptText()).userTailors(userPromptDto.getUserTailors())
                .commonTailors(userPromptDto.getCommonTailors()).build();
        return userPromptsRepo.save(userPrompt);
    }
}
