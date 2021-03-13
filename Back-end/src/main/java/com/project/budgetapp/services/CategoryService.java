package com.project.budgetapp.services;

import com.project.budgetapp.domain.ICategoryService;
import com.project.budgetapp.errors.ResourceNotFoundException;
import com.project.budgetapp.models.Category;
import com.project.budgetapp.repositories.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ResourceNotFoundException("No categories found");
        }
        return categories;
    }

    @Override
    public Category getCategory(Long id) throws ResourceNotFoundException {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category changeName(String newName, Long id) {
        Category category = categoryRepository.getOne(id);
        category.setCategory_name(newName);
        return categoryRepository.saveAndFlush(category);
    }
}
