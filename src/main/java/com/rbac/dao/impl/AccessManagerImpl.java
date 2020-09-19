package com.rbac.dao.impl;

import com.rbac.dao.AccessManager;
import com.rbac.model.AccessType;
import com.rbac.model.Resource;
import com.rbac.model.ResourceAccess;

import java.util.HashSet;
import java.util.Set;


public class AccessManagerImpl implements AccessManager {

    private Set<ResourceAccess> resourceAccessSet = new HashSet<>();

    @Override
    public boolean grantAccess(Resource resource, String roleId, AccessType accessType) {
        ResourceAccess tempResourceAccess = new ResourceAccess(resource.getResourceId(), accessType, roleId);
            return resourceAccessSet.add(tempResourceAccess);
    }

    @Override
    public boolean revokeAccess(Resource resource, String roleId, AccessType accessType) {
        ResourceAccess tempResourceAccess = new ResourceAccess(resource.getResourceId(), accessType, roleId);
        return resourceAccessSet.remove(tempResourceAccess);
    }

    @Override
    public boolean checkAccess(Resource resource, String roleId, AccessType accessType) {
        ResourceAccess tempResourceAccess = new ResourceAccess(resource.getResourceId(), accessType, roleId);
        ResourceAccess resourceAccess = resourceAccessSet.stream().filter(tempResourceAccess::equals).findAny().orElse(null);
        if(resourceAccess!=null && accessType.getLevel()<=resourceAccess.getAccessType().getLevel()){
            return true;
        }
        return false;
    }

}
