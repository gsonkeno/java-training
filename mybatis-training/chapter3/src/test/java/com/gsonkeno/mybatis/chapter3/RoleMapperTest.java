package com.gsonkeno.mybatis.chapter3;

import com.gsonkeno.mybatis.chapter3.mapper.RoleMapper;
import com.gsonkeno.mybatis.chapter3.model.SysRole;
import com.gsonkeno.mybatis.chapter3.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;


/**
 * Created by gaosong on 2018-04-06
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();

        try {
            RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
            SysRole sysRole = mapper.selectById(1L);
            System.out.println(sysRole);
        } finally {
            sqlSession.close();
        }
    }

}
