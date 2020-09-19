package com.rbac.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class SuperAdmin extends Person {

    public SuperAdmin(String userId, String userName, String email) {
        super(userId, userName, email, true);

    }

    public SuperAdmin(String userName, String email) {
        super(userName, email, true);

    }

}
