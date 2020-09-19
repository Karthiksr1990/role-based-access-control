package com.rbac.service.impl;

import com.rbac.dao.RoleManager;
import com.rbac.model.Person;
import com.rbac.model.Role;
import com.rbac.service.RolesService;
import com.rbac.service.UserService;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class RoleServiceImpl implements RolesService {

    private RoleManager roleManager;
    private UserService userService;
    @Override
    public Role createRole(String roleName) {
        return roleManager.createRole(roleName);
    }

    @Override
    public boolean addUser(String userId, String roleId) {
        Person person = userService.getUser(userId);
        return roleManager.addUser(person,roleId);
    }

    @Override
    public boolean removeUser(String userId, String roleId) {
        Person person = userService.getUser(userId);
        return roleManager.removeUser(person,roleId);
    }

    @Override
    public Set<Role> getRoleForUser(String userId) {
        return roleManager.getRoleForUser(userId);
    }
}
