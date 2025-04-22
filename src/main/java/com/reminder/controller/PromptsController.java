package com.reminder.controller;

import com.reminder.dto.UserPromptDto;
import com.reminder.entity.app.UserPrompt;
import com.reminder.service.PromptTailorsService;
import com.reminder.service.UserPromptService;
import com.reminder.service.user.UserPromptsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prompts")
public class PromptsController {
    private UserPromptsService userPromptsService;
    private PromptTailorsService promptTailorsService;
    private UserPromptService userPromptService;
    @GetMapping("/get")
    public ResponseEntity<List<String>> getUserPrompts(){
        return ResponseEntity.ok(userPromptsService.getUserPrompts());
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveChat(@Valid @RequestBody UserPromptDto userPromptDto){
        UserPrompt userPrompt = userPromptService.saveUserPrompt(userPromptDto);
        return ResponseEntity.ok(userPrompt.toString());
    }
}