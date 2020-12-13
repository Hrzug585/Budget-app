package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExpenseRepository extends JpaRepository<Expense, Long> {
//    List<Expense> findByAccount_id(Long Account_id);
}
