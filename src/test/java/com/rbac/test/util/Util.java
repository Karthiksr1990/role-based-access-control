package com.rbac.test.util;

import com.rbac.dao.AccessManager;
import com.rbac.dao.ResourceManager;
import com.rbac.dao.RoleManager;
import com.rbac.dao.UserManager;
import com.rbac.dao.impl.AccessManagerImpl;
import com.rbac.dao.impl.ResourceManagerImpl;
import com.rbac.dao.impl.RoleManagerImpl;
import com.rbac.dao.impl.UserManagerImpl;
import com.rbac.model.Customer;
import com.rbac.model.Person;
import com.rbac.model.Resource;
import com.rbac.model.Role;
import com.rbac.model.SuperAdmin;
import com.rbac.service.AccessService;
import com.rbac.service.RolesService;
import com.rbac.service.UserService;
import com.rbac.service.impl.AccessServiceImpl;
import com.rbac.service.impl.RoleServiceImpl;
import com.rbac.service.impl.UserServiceImpl;

import java.util.Random;
import java.util.UUID;

public class Util {

    private static RoleManager roleManager;
    private static AccessManager accessManager;
    private static ResourceManager resourceManager;
    private static UserManager userManager;
    private static RolesService rolesService;
    private static UserService userService;
    private static AccessService accessService;

    static {
        roleManager = new RoleManagerImpl();
        accessManager = new AccessManagerImpl();
        resourceManager = new ResourceManagerImpl();
        userManager = new UserManagerImpl();
        userService = new UserServiceImpl(userManager);
        rolesService = new RoleServiceImpl(roleManager, userService);
        accessService = new AccessServiceImpl(accessManager, rolesService, resourceManager, userService);
    }

    private static final String[] names = {"Ram", "Sam", "Ron", "Raj"};

    public static Person createUser() {

        Random random = new Random(2);
        int val=Math.max(0,random.nextInt()%3);
        String name=names[val];
        String nameUnique = name + UUID.randomUUID().toString();
        String email = names[val] + "@gmail.com";

        Person person = null;
            person = new Customer(UUID.randomUUID().toString(),name, email);
        userManager.createUser(person);

        return person;
    }

    public static Role createRole() {
        Random random = new Random(100);
        Role role = rolesService.createRole("role" + random.nextInt());
        return role;
    }

    public static Resource createResource() {
        Random random = new Random(100);
        Resource resource = new Resource(UUID.randomUUID().toString(),"resource" + random.nextInt());
        resourceManager.createResource(resource);
        return resource;
    }

    public static RoleManager getRoleManager() {
        return roleManager;
    }

    public static AccessManager getAccessManager() {
        return accessManager;
    }

    public static ResourceManager getResourceManager() {
        return resourceManager;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static RolesService getRolesService() {
        return rolesService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static AccessService getAccessService() {
        return accessService;
    }
}