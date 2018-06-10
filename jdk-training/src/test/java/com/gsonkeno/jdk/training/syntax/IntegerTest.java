package com.gsonkeno.jdk.training.syntax;

/**
 * Created by gaosong on 2018-02-02
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);

        Integer b = 3;

        Integer c = new Integer(3);

        //判断的是引用的地址，肯定不是一致的
        System.out.println(a == b);
        System.out.println(a == c);

        //Integer 与 int 比较时，会自动拆箱，比较的是两个数值的大小
        int d = 3;
        System.out.println(a == d); //true

        Integer e = 100, f = 100, g = 150, h = 150;

        //-128-127内的Integer对象，如果不是程序员显示new出来的，而是通过Integer e = 100这种方式创建的，会
        //调用Integer内部的valueOf(int i)方法，该方法内部会进行逻辑判断，如果入参在-128-127之间，直接返回内部
        //静态数组中的引用对象；如果在区间外，直接返回一个新的对象
        System.out.println( e == f); //true
        System.out.println( g == h);// false
    }
}
