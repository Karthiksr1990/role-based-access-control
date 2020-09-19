package com.rbac.service.test;

import com.rbac.dao.AccessManager;
import com.rbac.dao.ResourceManager;
import com.rbac.dao.RoleManager;
import com.rbac.dao.UserManager;
import com.rbac.model.AccessType;
import com.rbac.model.Person;
import com.rbac.model.Resource;
import com.rbac.model.Role;
import com.rbac.model.SuperAdmin;
import com.rbac.service.AccessService;
import com.rbac.service.RolesService;
import com.rbac.service.UserService;
import com.rbac.test.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Slf4j
public class AccessServiceTest {

    private static RoleManager roleManager;
    private static AccessManager accessManager;
    private static ResourceManager resourceManager;
    private static UserManager userManager;
    private static RolesService rolesService;
    private static UserService userService;
    private static AccessService accessService;
    private static Person admin;
    private Resource resource;
    private Role role;


    @BeforeClass
    public static void setup() {
        roleManager = Util.getRoleManager();
        accessManager = Util.getAccessManager();
        resourceManager = Util.getResourceManager();
        userManager = Util.getUserManager();
        userService = Util.getUserService();
        rolesService = Util.getRolesService();
        accessService = Util.getAccessService();
        admin = new SuperAdmin("111", "Karthik", "sdsa");
        userService.createUser(admin);
    }

    @Before
    public void beforeTest() {
        role = Util.createRole();
        resource = Util.createResource();
        log.info("Admin {}", admin);
        log.info("Role {}", role);
        log.info("Resource {}", resource);
    }

    @Test
    public void testNegativeCheckAccess() {

        Person user = Util.createUser();
        log.info("User {}", user);

        roleManager.addUser(user, role.getRoleId());
        accessService.grantAccess(admin.getUserId(), role.getRoleId(), resource.getResourceId(), AccessType.READ);
        Assert.assertFalse(accessService.checkAccess(user.getUserId(), resource.getResourceId(), AccessType.DELETE));
        Assert.assertFalse(accessService.checkAccess(user.getUserId(), resource.getResourceId(), AccessType.WRITE));

    }

    @Test
    public void testPositiveCheckAccess() {

        Person user = Util.createUser();
        log.info("User {}", user);

        roleManager.addUser(user, role.getRoleId());
        accessService.grantAccess(admin.getUserId(), role.getRoleId(), resource.getResourceId(), AccessType.DELETE);
        Assert.assertTrue(accessService.checkAccess(user.getUserId(), resource.getResourceId(), AccessType.READ));
        Assert.assertTrue(accessService.checkAccess(user.getUserId(), resource.getResourceId(), AccessType.WRITE));
        Assert.assertTrue(accessService.checkAccess(user.getUserId(), resource.getResourceId(), AccessType.DELETE));

    }

}
