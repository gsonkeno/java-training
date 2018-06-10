package com.gsonkeno.jdk.training.collection;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by gaosong on 2018-03-21
 */
public class ArrayListTest {


    /**
     * 验证ArrayList是线程不安全的,但是如果这样测试的话，Vector也会报类似的错误
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

    }

    public void removeSizeTest(){
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");

        CountDownLatch latch = new CountDownLatch(1);

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                int size = list.size();
                System.out.println(size);
                try {
                    latch.await();
                    System.out.println(list.get(size - 1));

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
                list.remove(2);
                latch.countDown();
            }
        };
        thread2.start();
    }


    /**
     * 测试 多线程1000个线程都进行移除最后一个元素，则会抛出类似以下异常。
     * Exception in thread "Thread-2" java.lang.IndexOutOfBoundsException: Index: 999, Size: 988
     * @throws InterruptedException
     */
    @Test
    public void removeTest() throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        int elemCount = 100;

        for (int i = 0; i < elemCount; i++) {
            list.add(i);
        }

        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(elemCount);

        for (int i = 0; i < elemCount; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch1.await();
                        list.remove(list.size() - 1);
                        System.out.println("线程" + Thread.currentThread().getName() + "执行结束");
                        latch2.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        latch1.countDown();
        latch2.await();

        System.out.println(list);
    }

    @Test
    public void testListToString(){

        String[] s = { " A ", " B", " C "};
        List<String> list  = Arrays.asList(s);
        //List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
        System.out.println(StringUtils.join(list,""));
    }
}
