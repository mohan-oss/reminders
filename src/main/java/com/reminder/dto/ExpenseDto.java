package com.reminder.dto;

import com.reminder.constants.enums.Currency;
import com.reminder.constants.enums.ExpenseCategories;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ExpenseDto {
    @NotBlank
    private String expenseName;
    private String expenseDescription;
    private ExpenseCategories category;
    @Builder.Default
    private Currency currency = Currency.INR;
    private BigDecimal amount;
}
