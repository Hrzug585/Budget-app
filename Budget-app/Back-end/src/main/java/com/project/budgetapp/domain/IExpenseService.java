package com.project.budgetapp.domain;

import com.project.budgetapp.models.Expense;

public interface IExpenseService {
    Expense getExpense(Long id);
    Expense createExpense(Expense expense);
    void deleteExpense(Long id);
}
