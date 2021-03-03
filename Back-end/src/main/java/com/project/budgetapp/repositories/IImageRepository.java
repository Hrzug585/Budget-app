package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IImageRepository extends JpaRepository<Image, Long> {
    @Query
    Image findImagesByExpenseId(Long id);
    void deleteAllByExpenseId(Long expense_id);
}
