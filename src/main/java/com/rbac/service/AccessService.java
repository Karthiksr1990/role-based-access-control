package com.rbac.service;

import com.rbac.model.AccessType;
import com.rbac.model.Resource;

public interface AccessService {
    boolean grantAccess(String userGivingAccess,String roleId,String resourceId,AccessType accessType);
    boolean checkAccess(String userId,String resourceId,AccessType accessType);
}
