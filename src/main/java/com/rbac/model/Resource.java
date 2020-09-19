package com.rbac.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Resource {

    @EqualsAndHashCode.Include
    private String resourceId;
    private String resourceName;

    public Resource(String resourceName) {
        this.resourceName = resourceName;
    }
}
