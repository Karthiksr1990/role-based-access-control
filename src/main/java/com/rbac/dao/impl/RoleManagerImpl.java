package com.rbac.dao.impl;

import com.rbac.constants.BusinessConstants;
import com.rbac.dao.RoleManager;
import com.rbac.exception.BusinessException;
import com.rbac.model.Person;
import com.rbac.model.Role;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RoleManagerImpl implements RoleManager {

    private Map<String, Role> roleMap = new HashMap<>();
    private Map<String, Set<Person>> roleCustomerMap = new HashMap<>();
    private Map<String, Set<Role>> userRoleMap = new HashMap<>();

    @Override
    public Role createRole(String roleName) {

        String roleId = java.util.UUID.randomUUID().toString();

        if (roleMap.containsKey(roleId)) {
            throw new BusinessException(BusinessConstants.ROLE_EXISTS.name(), BusinessConstants.ROLE_EXISTS.getCode());
        }
        Role role = new Role(roleId, roleName);

        roleMap.put(roleId, role);
        return role;
    }

    @Override
    public boolean addUser(Person user, String roleId) {
        isRoleExists(roleId);
        Set<Person> personSet = roleCustomerMap.getOrDefault(roleId, new HashSet<>());
        personSet.add(user);
        Set<Role> roleSet=userRoleMap.getOrDefault(user.getUserId(),new HashSet<>());
        roleSet.add(roleMap.get(roleId));
        userRoleMap.put(user.getUserId(),roleSet);
        return false;
    }

    @Override
    public boolean removeUser(Person user, String roleId) {
        isRoleExists(roleId);
        Set<Person> personSet = roleCustomerMap.getOrDefault(roleId, new HashSet<>());
        return personSet.remove(user);
    }

    @Override
    public Set<Role> getRoleForUser(String userId) {

        if(!userRoleMap.containsKey(userId)){
            throw new BusinessException(BusinessConstants.NO_ROLES_MAPPED_TO_USER.name(),BusinessConstants.NO_ROLES_MAPPED_TO_USER.getCode());
        }
        return new HashSet<>(userRoleMap.get(userId));

    }

    private void isRoleExists(String roleId) {
        boolean isRoleExists = roleMap.containsKey(roleId);
        if (!isRoleExists) {
            throw new BusinessException(BusinessConstants.ROLE_NOT_EXISTS.name(), BusinessConstants.ROLE_NOT_EXISTS.getCode());
        }
    }
}
