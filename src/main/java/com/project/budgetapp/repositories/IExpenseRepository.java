package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExpenseRepository extends JpaRepository<Expense, Long> {
}
