package com.gsonkeno.jdk.training.concurrent;

import sun.misc.Signal;

import javax.management.monitor.Monitor;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 测试一个main方法执行时jvm都运行了哪些线程
 * Created by gaosong on 2017-09-05
 */
public class MultiThread {
    public static void main(String[] args) {

        ThreadMXBean threadMxBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMxBean.dumpAllThreads(false, false);

        for (ThreadInfo threadInfo : threadInfos){
            System.out.println(threadInfo.getThreadId() + ":" + threadInfo.getThreadName());
        }
//        6:Monitor Ctrl-Break
//        5:Attach Listener 一种jvm进程间通信的能力
//        4:Signal Dispatcher 分发处理发送给JVM信号的线程
//        3:Finalizer 调用对象finalize的线程
//        2:Reference Handler 清除Reference的线程
//        1:main

    }
}
