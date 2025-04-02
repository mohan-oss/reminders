package com.reminder.entity.app;

import com.reminder.constants.enums.Currency;
import com.reminder.constants.enums.ExpenseCategories;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "expenses")
public class ExpenseEntity extends CommonAuditor{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "expense_name")
    private String expenseName;

    @Column(name = "expense_description")
    private String expenseDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ExpenseCategories category;

    @Column(name = "amount")
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;
}
