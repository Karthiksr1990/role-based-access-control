package com.rbac.constants;

public enum BusinessConstants {

    ROLE_EXISTS("BE100"),
    ROLE_NOT_EXISTS("BE101"),
    CUSTOMER_EXISTS("BE102"),
    CUSTOMER_NOT_EXISTS("BE103"),
    RESOURCE_EXISTS("BE104"),
    RESOURCE_NOT_EXISTS("BE105"),
    NO_ROLES_MAPPED_TO_USER("BE106"),
    NO_GRANT_ACCESS_PRIVILEGE("BE107");
    private String errorCode;

    private BusinessConstants(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCode(){
        return this.errorCode;
    }
}
