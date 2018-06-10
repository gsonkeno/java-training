package com.gsonkeno.jdk.training;

import com.gsonkeno.jdk.training.concurrent.DeadLock;

/**
 * Created by gaosong on 2018-03-24
 */
public class DeadLockTest {

    public static void main(String[] args) {
        DeadLock td1 = new DeadLock();
        DeadLock td2 = new DeadLock();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2都处于可执行状态，但JVM线程调度先执行哪个线程是不确定的。
        //td2的run()可能在td1的run()之前运行
        new Thread(td1).start();
        new Thread(td2).start();

    }
}
