package com.gsonkeno.jdk.training.syntax;


/**
 * Created by gaosong on 2018-03-25
 */
public class HashTest {

    public static void main(String[] args) {
        String s = new String("中国人");
        System.out.println(s.hashCode());
        s = new String("日国人");
        System.out.println(s.hashCode());
    }
}
