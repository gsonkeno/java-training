package com.gsonkeno.jdk.training;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal中的类声明部分的引导类
 * Created by gaosong on 2018-03-27
 */
public class ThreadId {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadId.get();
    }
}
