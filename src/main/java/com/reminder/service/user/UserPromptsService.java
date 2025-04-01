package com.reminder.service.user;

import com.reminder.dao.UserPromptsRepo;
import com.reminder.entity.UserPrompt;
import com.reminder.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserPromptsService {
    private UserPromptsRepo userPromptsRepo;

    public List<String> getUserPrompts(){
//        String userId = AppUtils.getUserPrinciple().getUserId();
        String userId = AppUtils.getCurrentUserId();
        if(userId == null || userId.isEmpty()){
            throw new RuntimeException("User not logged in");
        }
        return userPromptsRepo.findPromptsByUserId(userId);
    }

    public void saveUserPrompt(String text){
//        String userId = AppUtils.getUserPrinciple().getUserId();
        String userId = AppUtils.getCurrentUserId();
        UserPrompt userPrompt = UserPrompt.builder().prompt(text).userId(userId).build();
        userPromptsRepo.save(userPrompt);
    }
}
