package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.IAccountService;
import com.project.budgetapp.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final IAccountService accountService;

    @Autowired
    public AccountController(IAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> list() {
        return accountService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody final Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    @RequestMapping("{id}")
    public Account get(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
