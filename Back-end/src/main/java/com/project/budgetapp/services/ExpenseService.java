package com.project.budgetapp.services;

import com.project.budgetapp.domain.IAccountService;
import com.project.budgetapp.domain.IExpenseService;
import com.project.budgetapp.models.Expense;
import com.project.budgetapp.repositories.IExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ExpenseService implements IExpenseService {
    private final IExpenseRepository expenseRepository;
    private final IAccountService accountService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String defaultName = "expense";

    @Autowired
    public ExpenseService(IExpenseRepository expenseRepository, IAccountService accountService) {
        this.expenseRepository = expenseRepository;
        this.accountService = accountService;
    }

    @Override
    public Expense getExpense(Long id) {
        return expenseRepository.getOne(id);
    }

    @Override
    public Expense createExpense(Expense expense) {
        Expense newExpense = new Expense();
        if(expense.getName() == null) {
            newExpense.setName(defaultName);
        } else {
            newExpense.setName(expense.getName());
        }
        newExpense.setExpense_id(expense.getExpense_id());
        newExpense.setAccount_id(expense.getAccount_id());
        newExpense.setCategory_id(expense.getCategory_id());
        newExpense.setAmount(expense.getAmount());

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newExpense.setTimestamp((sdf.format(timestamp)));

        return expenseRepository.saveAndFlush(newExpense);
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getList(Long id) {
//        List<Expense> list = accountService.getAccount(id).getExpenseList();
//        return expenseRepository.findByAccount_id(id);

//        List<Expense> expenses =  expenseRepository.findAllExpenses(Sort.by("timestamp"));
        List<Expense> expenses = expenseRepository.findAllExpenses(id);
        return expenses;
    }

    @Override
    public List<Expense> getExpensesOfMonth(Long id, int year, int month) {
        if(month > 12 || month < 1) {
            throw new IllegalArgumentException("Choose month from 1-12 bracket");
        }
        String temp = Integer.toString(month);
        temp = temp.length() == 1 ? "0" + temp : temp;
        String timestamp = Integer.toString(year) + "-" + temp + "%";

        return expenseRepository.findAllExpensesInMonth(id, timestamp);
    }

    @Override
    public List<Object> getAllExpensesWithPhoto(Long id) {
        return expenseRepository.findAllExpensesContainingPhoto(id);
    }


}
