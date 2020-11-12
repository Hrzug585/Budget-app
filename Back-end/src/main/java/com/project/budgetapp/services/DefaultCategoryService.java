package com.project.budgetapp.services;

import com.project.budgetapp.models.DefaultCategory;
import com.project.budgetapp.repositories.IDefaultCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService {
    private final IDefaultCategoryRepository defaultCategoryRepository;

    @Autowired
    public DefaultCategoryService(IDefaultCategoryRepository defaultCategoryRepository) {
        this.defaultCategoryRepository = defaultCategoryRepository;
    }

    protected List<DefaultCategory> list() {
        return defaultCategoryRepository.findAll();
    }

    protected DefaultCategory get(Long id) {
        return defaultCategoryRepository.getOne(id);
    }
}
