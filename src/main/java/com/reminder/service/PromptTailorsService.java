package com.reminder.service;

import com.reminder.dao.CommonPromptTailorsRepo;
import com.reminder.dao.UserPromptTailorRepo;
import com.reminder.entity.CommonPromptTailors;
import com.reminder.entity.UserTailor;
import com.reminder.utils.AppUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromptTailorsService {
    private CommonPromptTailorsRepo commonPromptTailorsRepo;
    private UserPromptTailorRepo userPromptTailorRepo;


    public List<String> getCommonTailors(){
       return commonPromptTailorsRepo.findAll().stream().map(CommonPromptTailors::getTailor).collect(Collectors.toList());
    }

    public List<String> getUserTailors(){
//        String userId = AppUtils.getUserPrinciple().getUserId();
        String userId = AppUtils.getCurrentUserId();
        return userPromptTailorRepo.findByUserId(userId);
    }

    public void saveUserTailor(String userTailor) {
        String userId = AppUtils.getCurrentUserId();
        userPromptTailorRepo.save(UserTailor.builder().tailor(userTailor).userId(userId).build());
    }
}
