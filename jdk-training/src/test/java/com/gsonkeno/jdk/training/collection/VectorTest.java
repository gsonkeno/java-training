package com.gsonkeno.jdk.training.collection;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * Created by gaosong on 2018-03-21
 */
public class VectorTest {
    public static void main(String[] args) {
        List<String> vector = new Vector<String>();

        vector.add("a");
        vector.add("b");
        vector.add("c");

        CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int size = vector.size();
                System.out.println(size);
                try {
                    latch.await();
                    System.out.println(vector.get(size - 1));

                } catch (InterruptedException e) {
                }
            }
        };
        thread1.start();

        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
        }

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                vector.remove(2);
                latch.countDown();
            }
        };
        thread2.start();
    }
}
