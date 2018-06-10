package com.gsonkeno.mybatis.chapter2.mapper;

import com.gsonkeno.mybatis.chapter2.model.SysRole;
import com.gsonkeno.mybatis.chapter2.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * Created by gaosong on 2018-04-06
 */
public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();

    List<SysUser> selectAll2();

    int updateById(SysUser sysUser);

    /**
     * 根据用户id获取相关角色
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 批量更新用户
     * @param users
     */
    void batchUpdate(List<SysUser> users);

}
