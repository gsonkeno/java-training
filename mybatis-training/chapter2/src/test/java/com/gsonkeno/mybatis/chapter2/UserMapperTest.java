package com.gsonkeno.mybatis.chapter2;

import com.gsonkeno.mybatis.chapter2.mapper.UserMapper;
import com.gsonkeno.mybatis.chapter2.model.SysRole;
import com.gsonkeno.mybatis.chapter2.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


/**
 * Created by gaosong on 2018-04-06
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = mapper.selectById(1L);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = mapper.selectAll();
            Assert.assertNotNull(sysUsers);
            Assert.assertTrue(sysUsers.size() > 0);

        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll2(){
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysUser> sysUsers = mapper.selectAll2();
            System.out.println(sysUsers.size());
            Assert.assertNotNull(sysUsers);
            Assert.assertTrue(sysUsers.size() > 0);

        } finally {
            sqlSession.close();
        }
    }


    /**
     * 一次xml sql查询跨越多个表且返回一个实体(
     * 该实体包含对其他实体的引用，即SysRole实体有一个SysUser实体的属性)
     *
     */
    @Test
    public void testSelectRolesByUserId(){
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<SysRole> roles = mapper.selectRolesByUserId(1L);
            System.out.println(roles);
            System.out.println(roles.size());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateById(){
        SqlSession sqlSession = getSqlSession();

        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            SysUser sysUser = mapper.selectById(1L);
            System.out.println(sysUser);

            sysUser.setUserName("admin_test");
            sysUser.setUserEmail("8049203@163.com");

            int result = mapper.updateById(sysUser);

            System.out.println("影响的条数" + result);

            SysUser sysUser1 = mapper.selectById(1L);
            System.out.println(sysUser1);

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    /**
     * 测试批量更新用户
     */
    @Test
    public void testBatchUpdate(){
        SqlSession sqlSession = getSqlSession();

        try {
            List<SysUser> list = new ArrayList<>();
            SysUser user1 = new SysUser();
            user1.setId(1L);
            user1.setUserPassword("1236");
            list.add(user1);

            SysUser user2 = new SysUser();
            user2.setId(1001L);
            user2.setUserPassword("1235");
            list.add(user2);

            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.batchUpdate(list);
            sqlSession.commit();

        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
