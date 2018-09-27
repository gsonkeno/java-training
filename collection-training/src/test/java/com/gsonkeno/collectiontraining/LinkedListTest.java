package com.gsonkeno.collectiontraining;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    @Test
    public void test(){
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i<50000; i ++ ){
            linkedList.add(i);
        }

        long begin = System.currentTimeMillis();
        for (int i =0; i<50000; i++){
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - begin));

        begin = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println("耗时:"  + (end - begin));
    }

    @Test
    public void testMyLinkedList(){
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        for (int i = 0; i<50000; i ++ ){
            linkedList.add(i);
        }

        long begin = System.currentTimeMillis();
        for (int i =0; i<50000; i++){
            linkedList.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - begin));

        begin = System.currentTimeMillis();
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println("耗时:"  + (end - begin));
    }

    @Test
    public void testArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<>();

        long nums = 2000000;
        for (int i = 0; i<nums; i ++ ){
            arrayList.add(i);
        }

        long begin = System.currentTimeMillis();
        for (int i =0; i<nums; i++){
            arrayList.get(i);
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时:" + (end - begin));

        begin = System.currentTimeMillis();
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        end = System.currentTimeMillis();
        System.out.println("耗时:"  + (end - begin));
    }
}
