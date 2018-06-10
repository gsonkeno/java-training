package com.gsonkeno.aop.aspectj;

/**
 * Created by gaosong on 2017-11-29
 */
public aspect Audience {
    void around():call(void com.gsonkeno.aop.aspectj.Performance.perform()){
        sit();
        proceed();//代表调用原来的sayHello()方法
        applause();
    }

    private static void sit(){
        System.out.println("观众入座了....");
    }

    private static void applause(){
        System.out.println("观众鼓掌了");
    }
}
