package com.rbac.dao;

import com.rbac.model.Person;

public interface UserManager {
    void createUser(Person person);
    Person getUser(String userId);
}
