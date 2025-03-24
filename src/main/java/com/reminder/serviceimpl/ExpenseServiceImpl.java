package com.reminder.serviceimpl;

import com.reminder.constants.enums.Currency;
import com.reminder.dao.ExpenseRepo;
import com.reminder.dto.ExpenseDto;
import com.reminder.entity.ExpenseEntity;
import com.reminder.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepo expenseRepo;

    public ExpenseServiceImpl(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public List<ExpenseEntity> getExpense() {
        Iterable<ExpenseEntity> f = expenseRepo.findAll();
        return expenseRepo.findAll();
    }

    public void saveExpense(ExpenseDto expenseDto) {
        ExpenseEntity expenseEntity = ExpenseEntity.builder().expenseDescription(expenseDto.getExpenseDescription())
                .expenseName(expenseDto.getExpenseName()).category(expenseDto.getCategory())
                .currency(expenseDto.getCurrency()).amount(expenseDto.getAmount()).build();
        expenseRepo.save(expenseEntity);
        int[] ints = {2, 3};

    }

    public ExpenseEntity saveExpenseInINR(ExpenseDto expenseDto){
        if(expenseDto.getAmount()==null){
            throw new IllegalArgumentException("Amount cannot be null");
        }
        if(expenseDto.getCurrency().equals(Currency.USD)){
            expenseDto.setAmount(expenseDto.getAmount().multiply(BigDecimal.valueOf(85.0)));
            expenseDto.setCurrency(Currency.INR);
        }
        ExpenseEntity expenseEntity = ExpenseEntity.builder().expenseDescription(expenseDto.getExpenseDescription())
                .expenseName(expenseDto.getExpenseName()).category(expenseDto.getCategory())
                .currency(expenseDto.getCurrency()).amount(expenseDto.getAmount()).build();

        expenseRepo.save(expenseEntity);
        return expenseEntity;
    }

}
