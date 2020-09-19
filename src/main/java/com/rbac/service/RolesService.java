package com.rbac.service;

import com.rbac.model.Role;

import java.util.Set;

public interface RolesService {
   Role createRole(String roleName);
   boolean addUser(String userId,String roleId);
   boolean removeUser(String userId,String roleId);
   Set<Role> getRoleForUser(String userId);
}
