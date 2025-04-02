package com.reminder.service;

import com.reminder.dto.ExpenseDto;
import com.reminder.entity.app.ExpenseEntity;

import java.util.List;

public interface ExpenseService {
    public List<ExpenseEntity> getExpense();
    public void saveExpense(ExpenseDto expenseDto);
    public ExpenseEntity saveExpenseInINR(ExpenseDto expenseDto);
}
