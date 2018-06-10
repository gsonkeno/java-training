package com.gsonkeno.jdk.training;

/**
 * Created by gaosong on 2018-03-14
 */
public class FinalFinallyFinalize {
    //被声明为final的成员变量要么需要声明时指定初始值
    //要么在类的构造函数中指定初始值(注意，这里说的是成员变量，不是类变量(常量))
    private final int a = 5;

    public static void main(String[] args) {

    }

    //被声明为final的方法只能使用，不能重载
    public final int get(){
        return 0;
    }

    //该方法在垃圾回收器回收当前对象时会被调用
    @Override
    protected void finalize() throws Throwable {
        System.out.println("我被回收了");
    }
}
