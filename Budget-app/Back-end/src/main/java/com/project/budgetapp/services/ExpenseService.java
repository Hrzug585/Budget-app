package com.project.budgetapp.services;

import com.project.budgetapp.domain.IExpenseService;
import com.project.budgetapp.models.Expense;
import com.project.budgetapp.repositories.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService implements IExpenseService {
    private final IExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(IExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expense getExpense(Long id) {
        return expenseRepository.getOne(id);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.saveAndFlush(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
