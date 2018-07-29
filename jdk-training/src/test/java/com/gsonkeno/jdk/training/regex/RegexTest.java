package com.gsonkeno.jdk.training.regex;

import org.junit.Test;

/**
 * 正则训练
 */
public class RegexTest {

    //去除字符串中的所有非数字字符
    @Test
    public void test1(){
        String s = "139174^113913df45";
        System.out.println(s.replaceAll("[^\\d]+",""));
        System.out.println(s.replaceAll("[^0-9]+",""));
    }

    //判断字符串中是否存在非数字字符
    @Test
    public void test2(){
        String s = "^m";
        System.out.println(s.matches(".*[^\\d]+.*"));
        System.out.println(s.matches("[\\d]+"));

        System.out.println("------------");
        s = "8993";
        System.out.println(s.matches(".*[^\\d]+.*"));//包含1至多个数字则返回true
        System.out.println(s.matches("[\\d]+")); // 1至多个数字返回true

    }
}
