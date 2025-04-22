package com.reminder.service;

import com.reminder.dao.app.CommonPromptTailorsRepo;
import com.reminder.dao.app.UserPromptTailorRepo;
import com.reminder.entity.app.CommonPromptTailors;
import com.reminder.entity.app.UserTailor;
import com.reminder.utils.AppUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PromptTailorsService {
    private CommonPromptTailorsRepo commonPromptTailorsRepo;
    private UserPromptTailorRepo userPromptTailorRepo;


    public List<String> getCommonTailors(){
       return commonPromptTailorsRepo.findAll().stream().map(CommonPromptTailors::getTailor).collect(Collectors.toList());
    }

    @Cacheable("userTailorsCache")
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
