package com.rbac.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@ToString
public class Person {
    private String userName;
    @EqualsAndHashCode.Include
    private String userId;
    private String email;
    private boolean isSuperAdmin;

    public Person(String userId, String userName, String email) {
        this.userName = userName;
        this.userId = userId;
        this.email = email;
        this.isSuperAdmin=false;
    }

    public Person(String userName, String email, boolean isSuperAdmin) {
        this.userName = userName;
        this.email = email;
        this.isSuperAdmin = isSuperAdmin;
    }

    public Person(String userName, String email) {
        this.userName = userName;
        this.email = email;
        this.isSuperAdmin = false;
    }
}
