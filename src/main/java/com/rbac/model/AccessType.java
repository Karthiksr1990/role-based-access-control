package com.rbac.model;

public enum AccessType {
    READ(0),WRITE(1),DELETE(2);

    private int level;
    AccessType(int level) {
        this.level=level;
    }

    public int getLevel(){
        return level;
    }
}
