package com.rbac.service;

import com.rbac.model.Person;

public interface UserService {
    void createUser(Person person);
    Person getUser(String userId);
}
