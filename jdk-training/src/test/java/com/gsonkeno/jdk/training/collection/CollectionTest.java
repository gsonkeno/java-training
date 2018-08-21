package com.gsonkeno.jdk.training.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

    @Test
    public void testIterator(){
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> iterator = list.iterator();
        //不进行iterator.hasNext()判断就遍历输出元素的话
        //可能会抛出java.util.NoSuchElementException异常
//        while (true){
//            System.out.println(iterator.next());
//        }

        //调用iterator.remove()方法前，必须调且只调一次next()方法
        //否则，会抛出 java.lang.IllegalStateException异常
//        iterator.next();
//        iterator.remove();
//        iterator.remove();
        System.out.println(list);

    }
}
