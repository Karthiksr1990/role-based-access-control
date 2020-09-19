package com.rbac.dao;

import com.rbac.model.Person;
import com.rbac.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleManager {

    Role createRole(String roleName);
    boolean addUser(Person user,String roleId);
    boolean removeUser(Person user, String roleId);
    Set<Role> getRoleForUser(String userId);
}
