package com.rbac.model;

import lombok.ToString;

public class Customer extends Person {
    public Customer(String userName, String userId, String email) {
        super(userName, userId, email);
    }

    public Customer(String userName,String email) {
        super(userName, email);
    }
}
