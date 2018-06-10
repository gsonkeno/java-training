package com.gsonkeno.mybatis.chapter6.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SysUser {

    private SysRole role;
    private Long id;
    private String userName;
    private String userPassword;
    private List<SysRole> roleList;
    private String userEmail;
    private String userInfo;
    private Date createTime;
    private byte[] headImg;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }


    public String getUserEmail() {
        return userEmail;
    }


    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }


    public String getUserInfo() {
        return userInfo;
    }


    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public byte[] getHeadImg() {
        return headImg;
    }


    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "role=" + role +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roleList=" + roleList +
                ", userEmail='" + userEmail + '\'' +
                ", userInfo='" + userInfo + '\'' +
                ", createTime=" + createTime +
                ", headImg=" + Arrays.toString(headImg) +
                '}';
    }
}