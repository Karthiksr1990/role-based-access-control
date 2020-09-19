package com.rbac.dao.impl;

import com.rbac.constants.BusinessConstants;
import com.rbac.dao.ResourceManager;
import com.rbac.exception.BusinessException;
import com.rbac.model.Resource;

import java.util.HashMap;
import java.util.Map;

public class ResourceManagerImpl implements ResourceManager {
    private Map<String, Resource> resourceMap=new HashMap<>();

    @Override
    public void createResource(Resource resource) {

       if(resourceMap.containsKey(resource.getResourceId())){
           throw new BusinessException(BusinessConstants.RESOURCE_EXISTS.name(),BusinessConstants.RESOURCE_EXISTS.getCode());
        }
        resourceMap.put(resource.getResourceId(),resource);
    }

    @Override
    public Resource getResource(String resourceId) {
        if(!resourceMap.containsKey(resourceId)){
            throw new BusinessException(BusinessConstants.RESOURCE_NOT_EXISTS.name(),BusinessConstants.RESOURCE_NOT_EXISTS.getCode());
        }
        return resourceMap.get(resourceId);
    }
}
