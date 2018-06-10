package com.gsonkeno.mybatis.chapter6;

import com.gsonkeno.mybatis.chapter6.dao.SysUserMapper;
import com.gsonkeno.mybatis.chapter6.model.SysPrivilege;
import com.gsonkeno.mybatis.chapter6.model.SysRole;
import com.gsonkeno.mybatis.chapter6.model.SysRolePrivilege;
import com.gsonkeno.mybatis.chapter6.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * Created by gaosong on 2018-04-06
 */
public class UserMapperTest extends BaseMapperTest {

    /**
     * 一用户对应多角色情况下的一对多映射collection测试案例
     */
    @Test
    public void testSelectAllUserAndRoles(){
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> sysUsers = mapper.selectAllUserAndRoles();
            System.out.println("用户数:"  + sysUsers.size());

            for (SysUser sysUser : sysUsers) {
                System.out.println("用户名:" + sysUser.getUserName());
                for (SysRole sysRole : sysUser.getRoleList()) {
                    System.out.println("角色名:" + sysRole.getRoleName());
                }
            }
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试 resultMap下的association标签配置一对一映射
     */
    @Test
    public void testSelectUserAndRoleById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectUserAndRoleById(1001L);
            System.out.println(sysUser);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试 resultMap下的association标签嵌套查询，延迟加载
     */
    @Test
    public void testSelectUserAndRoleByIdSelect() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectUserAndRoleByIdSelect(1001L);
            System.out.println("使用延迟对象前后分界线");
            System.out.println(sysUser.getRole());
           // System.out.println(sysUser);
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 测试 resultMap下的association标签嵌套查询，延迟加载
     * 用户拥有多个角色，每个角色拥有多个权限
     */
    @Test
    public void testSelectSysRolesAndPrivilegeById() {
        SqlSession sqlSession = getSqlSession();

        try {
            SysUserMapper mapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser sysUser = mapper.selectSysRolesAndPrivilegeById(1L);
            System.out.println("获取用户信息前后分界线");
            System.out.println("获取角色信息前后分界线");
            List<SysRole> roleList = sysUser.getRoleList();


            for (SysRole sysRole : roleList) {
                System.out.println("角色名:" + sysRole.getRoleName());
            }

            System.out.println("---获取角色权限前后分界线---");
            for (SysRole sysRole : roleList) {
                List<SysPrivilege> privilegeList = sysRole.getPrivilegeList();
                System.out.println("角色名:" + sysRole.getRoleName());
                for (SysPrivilege sysRolePrivilege : privilegeList) {
                    System.out.println("角色权限:" +sysRolePrivilege);
                }
            }
        } finally {
            sqlSession.close();
        }
    }

}
