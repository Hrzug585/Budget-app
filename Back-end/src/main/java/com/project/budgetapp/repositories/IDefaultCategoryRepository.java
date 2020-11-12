package com.project.budgetapp.repositories;

import com.project.budgetapp.models.DefaultCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDefaultCategoryRepository extends JpaRepository<DefaultCategory ,Long> {
}
