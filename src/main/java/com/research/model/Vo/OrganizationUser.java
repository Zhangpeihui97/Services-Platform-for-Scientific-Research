package com.research.model.Vo;

public class OrganizationUser extends OrganizationUserKey {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}