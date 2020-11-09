package com.project.budgetapp.services;

import com.project.budgetapp.domain.IAccountService;
import com.project.budgetapp.models.Account;
import com.project.budgetapp.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;

    @Autowired
    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> list() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = this.getAccount(id);
        String localDate = LocalDate.now().toString();
        account.setAccount_deleted(localDate);
        accountRepository.saveAndFlush(account);
    }
}
