package com.project.budgetapp.services;

import com.project.budgetapp.domain.IAccountService;
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
        return accountRepository.findAll();
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.getOne(id);
    }

    @Override
    public Account createAccount(Account account) {
        List<DefaultCategory> defaultCategories = defaultCategoryService.list();
        Account newAccount =  accountRepository.saveAndFlush(account);

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
