package com.reminder.controller;

import lombok.AllArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
@AllArgsConstructor
public class ChatController {
    private OpenAiChatModel chatModel;

    @PostMapping("")
    public String chat(@RequestBody String text){
        Prompt prompt = new Prompt(text);
        ChatResponse call = chatModel.call(prompt);
        return call.getResult().getOutput().getText();
    }
}
