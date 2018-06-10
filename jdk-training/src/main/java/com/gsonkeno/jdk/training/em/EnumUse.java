package com.gsonkeno.jdk.training.em;

/**
 * 枚举方法的基本使用
 * ordinal()方法返回枚举实例的位置，第一位为0，依次递加
 */
public class EnumUse {

    enum  Type{
        SOLID, LIQUID, GAS
    }

    public static void main(String[] args) {
        System.out.println(Type.GAS.ordinal());
    }
}
