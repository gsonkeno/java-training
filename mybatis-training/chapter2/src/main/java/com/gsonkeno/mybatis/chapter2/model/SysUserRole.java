package com.gsonkeno.mybatis.chapter2.model;

/**
 * Created by gaosong on 2018-04-06
 */
public class SysUserRole {
    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
