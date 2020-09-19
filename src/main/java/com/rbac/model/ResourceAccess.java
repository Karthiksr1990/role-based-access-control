package com.rbac.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ResourceAccess {
    @EqualsAndHashCode.Include
    private String resourceId;
    private AccessType accessType;
    @EqualsAndHashCode.Include
    private String roleId;
}
