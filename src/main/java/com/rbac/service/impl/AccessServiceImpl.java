package com.rbac.service.impl;

import com.rbac.constants.BusinessConstants;
import com.rbac.dao.AccessManager;
import com.rbac.dao.ResourceManager;
import com.rbac.exception.BusinessException;
import com.rbac.model.AccessType;
import com.rbac.model.Person;
import com.rbac.model.Resource;
import com.rbac.model.Role;
import com.rbac.service.AccessService;
import com.rbac.service.RolesService;
import com.rbac.service.UserService;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class AccessServiceImpl implements AccessService {

    private AccessManager accessManager;
    private RolesService rolesService;
    private ResourceManager resourceManager;
    private UserService userService;
    @Override
    public boolean grantAccess(String userGivingAccess, String roleId, String resourceId, AccessType accessType) {

       Person person = userService.getUser(userGivingAccess);
        if(person.isSuperAdmin()) {
            Resource resource = resourceManager.getResource(resourceId);
            return accessManager.grantAccess(resource, roleId, accessType);
        }else{
            throw new BusinessException(BusinessConstants.NO_GRANT_ACCESS_PRIVILEGE.name(),BusinessConstants.NO_GRANT_ACCESS_PRIVILEGE.getCode());
        }
    }

    @Override
    public boolean checkAccess(String userId, String resourceId, AccessType accessType) {

        Person person=userService.getUser(userId);

        if(person.isSuperAdmin()){
            return true;
        }

        Resource resource = resourceManager.getResource(resourceId);
        Set<Role> roles= rolesService.getRoleForUser(userId);

        boolean isAllowed=false;
        for(Role role :roles){
            isAllowed = isAllowed || accessManager.checkAccess(resource,role.getRoleId(),accessType);
        }

        return isAllowed;
    }
}
