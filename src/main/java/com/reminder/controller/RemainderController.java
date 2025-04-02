package com.reminder.controller;

import com.reminder.dto.GetRemaindersRequestDto;
import com.reminder.dto.SaveRemainderDto;
import com.reminder.entity.app.Reminder;
import com.reminder.service.RemainderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@Slf4j
public class RemainderController {

    private RemainderService remainderService;
    final String userId = "9fd3e175-84d1-4253-aa62-eea63a46eb67";
    @PostMapping("/reminders/save")
    public String saveReminder(@ModelAttribute @Valid SaveRemainderDto remainderDto, BindingResult result){
        if(result.hasErrors()){
            return "save/save-reminder";
        }
//        remainderDto.setUserId(AppUtils.getUserPrinciple().getUserId());
        remainderDto.setUserId(userId);
        remainderService.saveRemainder(remainderDto);
        return "redirect:/get-reminders";
    }

    @GetMapping("/reminders/new")
    public String reminder(Model model){
        model.addAttribute("reminder", new SaveRemainderDto());
        return "save/save-reminder";
    }

    @PostMapping("/remainders")
    @ResponseBody
    public ResponseEntity<Page<Reminder>> remainder(@Valid @RequestBody GetRemaindersRequestDto dto, Model model){
        log.info("remainder called {}", dto);
        Page<Reminder> remainders = remainderService.getRemainders(dto);
        return ResponseEntity.ok(remainders);
    }

    @GetMapping("/get-reminders")
    public String home(Model model){
        log.info("home called");
        String userId = "9fd3e175-84d1-4253-aa62-eea63a46eb67";
//                AppUtils.getUserPrinciple().getUserId();
        Page<Reminder> reminders = remainderService.getRemainders(GetRemaindersRequestDto.builder()
                .pageNumber(0)
                .pageSize(10)
                .userId(userId)
                .build());
        log.info("Total Pages: {}, Total Elements: {}, Current Page Size: {}",
                reminders.getTotalPages(), reminders.getTotalElements(), reminders.getSize());

        log.info("First Reminder (if exists): {}",
                reminders.hasContent() ? reminders.getContent().get(0) : "No Data");
        model.addAttribute("reminders",reminders);
        return "list/reminders";
    }

    @GetMapping("/favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // This method just handles the request and returns nothing
    }
}
