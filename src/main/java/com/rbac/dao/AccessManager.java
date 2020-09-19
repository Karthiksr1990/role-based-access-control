package com.rbac.dao;

import com.rbac.model.AccessType;
import com.rbac.model.Resource;

public interface AccessManager {

    boolean grantAccess(Resource resource, String roleId, AccessType accessType);
    boolean revokeAccess(Resource resource, String roleId, AccessType accessType);
    boolean checkAccess(Resource resource, String roleId, AccessType accessType);
}
