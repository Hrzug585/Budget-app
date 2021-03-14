package com.project.budgetapp.domain;


import com.project.budgetapp.errors.ResourceNotFoundException;
import com.project.budgetapp.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> list();
    Category getCategory(Long id) throws ResourceNotFoundException;
    Category createCategory(Category category);
    Category changeName(String newName, Long id);
}
