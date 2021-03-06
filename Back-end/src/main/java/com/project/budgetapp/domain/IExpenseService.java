package com.project.budgetapp.domain;

import com.project.budgetapp.models.Expense;

import java.util.List;

public interface IExpenseService {
    Expense getExpense(Long id);
    Expense createExpense(Expense expense);
    void deleteExpense(Long id);
    List<Expense> getList(Long id);
    List<Expense> getExpensesOfMonth(Long id, int year, int month);
    List<Object> getAllExpensesWithPhoto(Long id);
}
