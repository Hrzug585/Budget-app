package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
