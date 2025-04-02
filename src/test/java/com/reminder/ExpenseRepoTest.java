package com.reminder;

import com.reminder.dao.app.ExpenseRepo;
import com.reminder.entity.app.ExpenseEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
@ExtendWith(MockitoExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ExpenseRepoTest {

    @Autowired
    private ExpenseRepo expenseRepo;
    @Test
    public void verifySaveExpense(){
        ExpenseEntity expenseEntity = ExpenseEntity.builder().expenseName("Petrol").expenseDescription("Saturday VJY").amount(new BigDecimal("23.90"))
                .build();
        expenseRepo.save(expenseEntity);

        ExpenseEntity expenseEntity1 = ExpenseEntity.builder().expenseName("Biryani").expenseDescription("Saturday VJY").amount(new BigDecimal("23.90"))
                .build();
        expenseRepo.save(expenseEntity1);
    }
}
