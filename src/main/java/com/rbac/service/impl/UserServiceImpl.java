package com.rbac.service.impl;

import com.rbac.dao.UserManager;
import com.rbac.model.Person;
import com.rbac.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserManager userManager;

    @Override
    public void createUser(Person person) {
        userManager.createUser(person);
    }

    @Override
    public Person getUser(String userId) {
        return userManager.getUser(userId);
    }
}
