package com.gsonkeno.spring.test;

import com.gsonkeno.spring.jdbc.User;
import com.gsonkeno.spring.jdbc.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by gaosong on 2018-04-04
 */
public class SpringJdbcTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Jdbc.xml");

        UserService userService = (UserService) ac.getBean("userService");

        User user = new User();
        user.setName("张三");
        user.setAge(20);
        user.setSex("男");

        userService.saveUser(user);

        List<User> users = userService.getUsers();
        System.out.println(users);

    }
}
