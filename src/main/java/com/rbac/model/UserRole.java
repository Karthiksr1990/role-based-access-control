package com.rbac.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRole {

    private String userId;
    private String roleId;
}
