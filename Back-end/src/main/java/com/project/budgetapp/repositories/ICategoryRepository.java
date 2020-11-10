package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
