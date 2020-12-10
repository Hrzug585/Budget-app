package com.project.budgetapp.controllers;

import com.project.budgetapp.domain.IRegistrationService;
import com.project.budgetapp.models.User;
import com.project.budgetapp.security.UserSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {
    private final IRegistrationService registrationService;
    private final UserSecurityConfig userSecurityConfig;

    @Autowired
    public RegistrationController(IRegistrationService registrationService, UserSecurityConfig userSecurityConfig) {
        this.registrationService = registrationService;
        this.userSecurityConfig = userSecurityConfig;
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createUser(@RequestBody final User user) {
        User newUser = new User();
        newUser.setUser_id(user.getUser_id());
        newUser.setUser_name(user.getUser_name());
        String encoded = userSecurityConfig.encoder().encode(user.getUser_password());
        newUser.setUser_password(encoded);
        return registrationService.createUser(newUser);
    }
}
