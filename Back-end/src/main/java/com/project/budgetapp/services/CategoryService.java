package com.project.budgetapp.services;

import com.project.budgetapp.domain.ICategoryService;
import com.project.budgetapp.models.Category;
import com.project.budgetapp.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }
}
