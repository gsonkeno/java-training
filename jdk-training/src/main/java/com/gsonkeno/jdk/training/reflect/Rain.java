package com.gsonkeno.jdk.training.reflect;

/**
 * Created by gaosong on 2017-09-01
 */
public class Rain implements Atmosphere{

    public void behave(){
        System.out.println("rain is falling");
    }

    public void effect(){
        System.out.println("消除旱灾");
    }
}
