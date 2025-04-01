package com.reminder.controller;

import com.reminder.service.PromptTailorsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TailorController {
    private PromptTailorsService tailorsService;

    @GetMapping("/user/tailors")
    public ResponseEntity<List<String>> getUserTailors(){
        return ResponseEntity.ok(tailorsService.getUserTailors());
    }

    @PostMapping("/save-user-tailer")
    public ResponseEntity<String> saveUserTailor(@RequestBody String userTailor){
        tailorsService.saveUserTailor(userTailor);
        return ResponseEntity.ok("Saved");
    }

    @GetMapping("/common/prompt-tailors")
    public ResponseEntity<List<String>> getCommonPromptTailors(){
        return ResponseEntity.ok(tailorsService.getCommonTailors());
    }
}
