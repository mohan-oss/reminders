package com.reminder.controller;

import com.reminder.dto.ResponseDto;
import com.reminder.dto.ExpenseDto;
import com.reminder.service.EmailService;
import com.reminder.service.ExpenseService;
import com.reminder.utils.AppUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Expense crud operations")
//@RequestMapping(UrlMappingConstants.EXPENSE_MAPPING)
@AllArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private EmailService emailService;

    @Operation(summary = "Add expense", description = "Post request for adding expense")
    @PostMapping("/save-expense")
    public ResponseEntity<String> addExpense(@RequestBody @Valid ExpenseDto expenseDto) {
        log.info("addExpense called expenseDto = {}", expenseDto);
        expenseService.saveExpense(expenseDto);
        return ResponseEntity.ok()
                .body("Saved");
    }

    @GetMapping("/get-expenses")
    public ResponseEntity<ResponseDto> getExpenses() {
        return ResponseEntity.ok().body(ResponseDto.builder().body(expenseService.getExpense())
                .status(true).build());
    }

    @GetMapping("/test")
    public ResponseEntity<ResponseDto> sayHi() {
        return ResponseEntity.ok().body(ResponseDto.builder().body(AppUtils.getUserPrinciple())
                .status(true).build());
    }

    @GetMapping("/send-email")
    public ResponseEntity<String> sendEmail(){
        log.info("sendEmail called ");
        emailService.sendEmailWithTable("mohansurendar.mullapudi@gmail.com","Expenses for this month");
        return ResponseEntity.ok("Email triggered");
    }
}
