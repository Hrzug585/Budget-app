package com.project.budgetapp.repositories;

import com.project.budgetapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
