package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.IExpenseService;
import com.project.budgetapp.models.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final IExpenseService expenseService;

    @Autowired
    public ExpenseController(IExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("{id}")
    public Expense get(@PathVariable Long id) {
        return expenseService.getExpense(id);
    }

    @GetMapping("list/{id}")
    public List<Expense> list(@PathVariable Long id) {
        return expenseService.getList(id);
    }

    @PostMapping("delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Expense createExpense(@RequestBody final Expense expense) {
        return expenseService.createExpense(expense);
    }
}
