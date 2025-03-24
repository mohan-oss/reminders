package com.reminder;

import com.reminder.constants.enums.Currency;
import com.reminder.dao.ExpenseRepo;
import com.reminder.dto.ExpenseDto;
import com.reminder.entity.ExpenseEntity;
import com.reminder.serviceimpl.ExpenseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {


    @InjectMocks
    private ExpenseServiceImpl service;

    @Mock
    private ExpenseRepo expenseRepo;

    private ExpenseDto expenseDto;

    @BeforeEach
    public void init(){
        expenseDto =  expenseDto.builder().expenseName("Petrol").expenseDescription("Saturday VJY").amount(new BigDecimal("23.90"))
                .currency(Currency.USD).build();
    }

    @Test
    public void test1(){
       // Mockito.when(expenseRepo.save(ArgumentMatchers.any(ExpenseEntity.class))).thenReturn(null);

        ExpenseEntity expenseEntity = service.saveExpenseInINR(expenseDto);
        System.out.println(expenseEntity+"");
    }

    @Test
    public void saveExpenseNegative_verifyException(){
        expenseDto.setAmount(null);
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> service.saveExpenseInINR(expenseDto));
        assertEquals("Amount cannot be null",illegalArgumentException.getMessage());
    }
}
