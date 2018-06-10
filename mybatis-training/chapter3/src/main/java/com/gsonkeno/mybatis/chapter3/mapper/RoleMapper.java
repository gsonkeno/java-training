package com.gsonkeno.mybatis.chapter3.mapper;

import com.gsonkeno.mybatis.chapter3.model.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * Created by gaosong on 2018-04-07
 */
public interface RoleMapper {
    @Select({"select id, role_name roleName, enabled," +
            " create_by createBy, create_time createTime " +
            " from sys_role" +
            " where id = #{id}"})
    SysRole selectById(Long id);
}
