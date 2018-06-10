package com.gsonkeno.jdk.training.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by gaosong on 2017-09-01
 */
public class RainManage {
    static class RainProxy implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
           if (method.getName().equals("behave")){
               System.out.println("wing is  alwayls strong before raining");
           }
           return proxy;
        }
    }

    public static Atmosphere createRain(){
        Object o = Proxy.newProxyInstance(RainManage.class.getClassLoader(),
                new Class<?>[]{Atmosphere.class}, new RainProxy());
        System.out.println(o);
        return (Atmosphere)o;
    }
}
