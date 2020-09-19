package com.rbac.dao;

import com.rbac.model.Resource;

public interface ResourceManager {

    void createResource(Resource resource);
    Resource getResource(String resourceId);

}