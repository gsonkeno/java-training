package com.gsonkeno.jdk.training.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by gaosong on 2017-09-14
 * Thread有6中状态: NEW, RUNNABLE(Running + ready), BLOCKED, WAITING, TIMED_WAITING, TERMINATED
 *
 * 
 */
public class ThreadUse {

    private static Object o  = new Object();

    public static void main(String[] args) {
        //runnable2Blocked();
        //runnable2WaitByWait();
        //runnable2WaitByJoin();
        //runnable2WaitByPark();
        //testInterrupt();
        testInterrupted();
        //testInterruptOnBlocked();
    }

    /**
     * 两个线程几乎同时执行，任务对类对象加锁。
     * 一定有一个线程获取锁后循环不退出；另一个线程获取不到锁阻塞
     */
    private static void runnable2Blocked(){
        Thread thread1 = new Thread(new RunCase(), "RunCase1");
        Thread thread2 = new Thread(new RunCase(), "RunCase2");

        thread1.start();
        thread2.start();
    }

    /**
     * 由运行状态转到waiting状态，调用wait
     */
    private static void runnable2WaitByWait()  {
        synchronized (o){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 由运行状态转到waiting状态，调用join
     * RunCase线程一直在运行，不会结束；导致main线程处于waiting状态
     */
    private static void runnable2WaitByJoin()  {
        Thread thread = new Thread(new RunCase(), "RunCase");
        thread.start();

        SleepUtil.sleep(2);
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 由运行状态转到waiting状态，调用LockSupport.park()
     * 该方法导致当前线程(此处是main线程)阻塞，状态变为waiting
     * 返回常见的有两种方式，unpark()或者被中断
     */
    private static void runnable2WaitByPark()  {
        LockSupport.park();
    }

    /**
     * 测试中断线程
     * 1)处于正常运行中的线程如果被中断，只是修改了一下中断标识位
     * 2)处于阻塞状态(如wating)的线程被中断，中断标识位会复位，且会抛出异常
     *   方法上本身也声明了会抛出异常,如wait()就声明抛出中断异常
     */
    private static void testInterrupt(){
        //Thread thread = new Thread(new RunCase(), "RunCase");
        Thread thread = new Thread(new BlockRunCase(), "RunCase");
        thread.start();

        SleepUtil.sleep(2);
        thread.interrupt();
    }

    /**
     * 测试当前线程是否被中断，不管其有没有被中断，中断标识位都会被清除
     *
     * 正常情况下连续调用该方法两次，第二次会返回false;
     *
     * 除非第一次调用后，第二次调用前，当前线程又被中断了，这么短的时间内
     * 发生该事件的概率是极低的
     */
    private static void testInterrupted(){
        Thread thread = Thread.currentThread();
        thread.interrupt();
        //先中断该线程，则Thread.interrupted()返回true，
        //中断标识位被清除，再次调用，则判断为false

        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

    /**
     * 测试一个线程处在blocked状态时，被中断的反应
     * 不会抛出异常，只是改变状态位
     */
    private static void testInterruptOnBlocked(){
        Thread thread1 = new Thread(new RunCase(), "RunCase1");
        Thread thread2 = new Thread(new RunCase(), "RunCase2");

        thread1.start();
        SleepUtil.sleep(2);
        thread2.start();
        thread2.interrupt();
        System.out.println(thread2.isInterrupted());

        SleepUtil.sleep(2);
    }


    /**
     * sleep不会导致当前线程释放所占用的锁,而wait会
     *
     * sleep会导致当前线程进入timed-wating状态
     * wait导致当前线程进入wating状态
     */
    private static void testSleep(){
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用wait()方法使线程处于waiting状态
     */
    private static void testWait(){
        Thread thread = new Thread(new BlockRunCase(), "RunCase");
        thread.start();
    }

    private static class RunCase implements Runnable{
        @Override
        public void run() {
            synchronized (RunCase.class){
                while (true){
                }
            }
        }
    }

    private static class BlockRunCase implements Runnable{
        @Override
        public void run() {
            synchronized (RunCase.class){
                while (true){
                    try {
                        RunCase.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
