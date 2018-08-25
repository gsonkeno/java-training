package com.gsonkeno.collectiontraining;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListVectorTest {
    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        //add前，ArrayList的内部元素 elementData数组(默认构造函数)的大小是0
        //根据预估的元素个数 size + 1 来判断是否进行数组扩容
        //扩容后的最小容量默认是DEFAULT_CAPACITY = 10
        //所以该行代码执行后，elementData数组大小是10
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }
}
