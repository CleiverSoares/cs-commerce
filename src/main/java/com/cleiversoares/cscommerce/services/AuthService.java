package com.cleiversoares.cscommerce.services;

import com.cleiversoares.cscommerce.entities.User;
import com.cleiversoares.cscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(Long userId) {
        User me = userService.authenticated();
        if (me == null || (!me.getId().equals(userId) && !me.hasRole("ROLE_ADMIN"))) {
            throw new ForbiddenException("Acesso negado");
        }
    }
}