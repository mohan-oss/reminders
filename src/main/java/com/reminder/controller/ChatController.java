package com.reminder.controller;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {
    @Autowired
    private OpenAiChatModel chatModel;

    @PostMapping("/chat")
    public String chat(@RequestBody String text){
        Prompt prompt = new Prompt(text);
        ChatResponse call = chatModel.call(prompt);
        return call.getResult().getOutput().getText();
    }
}
