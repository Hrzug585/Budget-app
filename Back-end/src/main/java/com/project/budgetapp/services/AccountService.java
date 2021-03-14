package com.project.budgetapp.services;

import com.project.budgetapp.domain.IAccountService;
import com.project.budgetapp.errors.ResourceNotFoundException;
import com.project.budgetapp.models.Account;
import com.project.budgetapp.models.Category;
import com.project.budgetapp.models.DefaultCategory;
import com.project.budgetapp.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    private final IAccountRepository accountRepository;
    private final DefaultCategoryService defaultCategoryService;
    private final CategoryService categoryService;

    @Autowired
    public AccountService(IAccountRepository accountRepository, DefaultCategoryService defaultCategoryService, CategoryService categoryService) {
        this.accountRepository = accountRepository;
        this.defaultCategoryService = defaultCategoryService;
        this.categoryService = categoryService;
    }

    @Override
    public List<Account> list() {
        List<Account> accounts = accountRepository.findAll();
        if(accounts.isEmpty()) {
            throw new ResourceNotFoundException("No accounts found");
        }
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account with this id does not exist"));
    }

    @Override
    public Account createAccount(Account account) {
        Account newAccount =  accountRepository.saveAndFlush(account);
        List<DefaultCategory> defaultCategories = defaultCategoryService.list();

        for (DefaultCategory c : defaultCategories) {
            Category category = new Category(c.getCategory_name(), newAccount.getAccount_id());
            categoryService.createCategory(category);
        }

        return accountRepository.saveAndFlush(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
