package com.project.budgetapp.services;

import com.project.budgetapp.domain.IRegistrationService;
import com.project.budgetapp.models.User;
import com.project.budgetapp.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements IRegistrationService {
    private final IUserRepository userRepository;

    @Autowired
    public RegistrationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.saveAndFlush(user);
    }
}
