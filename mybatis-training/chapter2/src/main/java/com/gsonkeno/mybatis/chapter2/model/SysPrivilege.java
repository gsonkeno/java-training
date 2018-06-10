package com.gsonkeno.mybatis.chapter2.model;

/**
 * Created by gaosong on 2018-04-06
 */
public class SysPrivilege {
    private Long id;
    private String privilegeName;
    private String priviligeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPriviligeUrl() {
        return priviligeUrl;
    }

    public void setPriviligeUrl(String priviligeUrl) {
        this.priviligeUrl = priviligeUrl;
    }
}
