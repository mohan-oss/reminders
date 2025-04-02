package com.reminder.dao.app;

import com.reminder.entity.app.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity,String> {
}
