package com.reminder.controller;

import com.reminder.service.PromptTailorsService;
import com.reminder.service.user.UserPromptsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PromptsController {
    private UserPromptsService userPromptsService;
    private PromptTailorsService promptTailorsService;
    @GetMapping("/user/prompts")
    public ResponseEntity<List<String>> getUserPrompts(){
        return ResponseEntity.ok(userPromptsService.getUserPrompts());
    }

    @PostMapping("/user/save-prompt")
    public ResponseEntity<Object> saveUserPrompt(@RequestBody String prompt){
        userPromptsService.saveUserPrompt(prompt);
        return ResponseEntity.ok("Saved");
    }
}