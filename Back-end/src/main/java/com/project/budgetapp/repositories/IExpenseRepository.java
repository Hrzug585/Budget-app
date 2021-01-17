package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Expense;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IExpenseRepository extends JpaRepository<Expense, Long> {
//    List<Expense> findByAccount_id(Long Account_id);

    @Query("SELECT exp FROM expenses exp WHERE exp.account_id = ?1 order by exp.timestamp desc ")
    List<Expense> findAllExpenses(Long accountId);

    @Query("SELECT exp FROM expenses exp WHERE exp.account_id = ?1 and exp.timestamp like ?2 order by exp.timestamp desc ")
    List<Expense> findAllExpensesInMonth(Long accountId, String timestamp);

//    select * from  expenses inner join images on expenses.expense_id = images.expense_id where expenses.account_id = 1;
    @Query("SELECT exp, img FROM expenses exp inner join images img on exp.expense_id = img .expenseId WHERE exp.account_id = ?1 order by exp.timestamp desc ")
    List<Object> findAllExpensesContainingPhoto(Long id);
}
