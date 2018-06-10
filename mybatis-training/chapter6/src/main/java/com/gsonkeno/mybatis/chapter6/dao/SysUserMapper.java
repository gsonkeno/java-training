package com.gsonkeno.mybatis.chapter6.dao;

import com.gsonkeno.mybatis.chapter6.model.SysUser;

import java.util.List;

public interface SysUserMapper {

    List<SysUser> selectAllUserAndRoles();

    SysUser selectUserAndRoleById(Long id);

    SysUser selectUserAndRoleByIdSelect(Long id);

    /**
     * 嵌套查询(懒加载)获取指定用户的角色列表信息
     * 及权限列表信息
     * @param id
     * @return
     */
    SysUser selectSysRolesAndPrivilegeById(Long id);
}