package com.gsonkeno.jdk.training.jdk8;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class OptionalUse {

    //优雅的处理User可能为null的情况
    static  String getUserName(User user){

        //将一般对象转换为Optional对象，可能是一个包裹值的Optional，
        // 也可能是一个没有值的Optional
        Optional<User> optUser = Optional.ofNullable(user);

        //map映射，获取name属性；如果u为空实例，直接返回空实例;
        //如果u不为空实例，但是u.getName()返回null，则结果返回空Optional
        Optional<String> name = optUser.map(u -> u.getName());


        //如果name为空Optional,则返回自定义的值；否则，返回name实例包裹的value值
        return name.orElse("unKown");

        //1.
        // 如果采用链式调用，则代码应该书写为以下形式
        //return Optional.ofNullable(user).map(u->u.getName()).orElse("unKown");

        //2.
        //但是如果我们并不需要返回一个默认值，而是结果为null时，抛出自定义异常怎么办呢?
        //可以使用orElseThrow方法如下
        //name.orElseThrow(()->new IllegalArgumentException("the name of the user is not prsent"));
    }

    static class User{
        private  String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        User user = new User();
        String userName = getUserName(user);
        System.out.println(userName);

        user = null;
        System.out.println(getUserName(user));



    }
}
