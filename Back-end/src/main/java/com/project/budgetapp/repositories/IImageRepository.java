package com.project.budgetapp.repositories;

import com.project.budgetapp.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImageRepository extends JpaRepository<Image, Long> {
    Image findImagesByExpenseId(long expense_id);
}
