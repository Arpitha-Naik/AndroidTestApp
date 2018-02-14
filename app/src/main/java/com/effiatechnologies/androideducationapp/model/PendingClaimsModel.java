package com.effiatechnologies.androideducationapp.model;

/**
 * Created by Administrator on 06-12-2016.
 */

public class PendingClaimsModel {

    private int roleCode;
    private String roleName;


    public PendingClaimsModel()
    {

    }

    public PendingClaimsModel(int roleCode, String roleName)
    {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(int roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "PendingClaimsModel{" +
                "roleCode=" + roleCode +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
