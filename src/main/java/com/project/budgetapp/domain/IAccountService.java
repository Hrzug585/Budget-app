package com.project.budgetapp.domain;

import com.project.budgetapp.models.Account;

import java.util.List;

public interface IAccountService {
    List<Account> list();
    Account getAccount(Long id);
    Account createAccount(Account account);
    void deleteAccount(Long id);
}
