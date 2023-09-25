package com.example.project05.common;

public enum UserRoleEnum {
    ADMIN(2, "admin"),
    USER(3, "user"),
    DBA(1, "dba");

    private Integer roleId;

    private String userRole;

    public Integer getRoleId() {
        return roleId;
    }

    public String getUserRole() {
        return userRole;
    }

    UserRoleEnum(Integer roleId, String userRole) {
        this.userRole = userRole;
        this.roleId = roleId;
    }
}
