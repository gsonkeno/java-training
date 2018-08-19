package com.gsonkeno.commoncollectionstraining;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.junit.Test;

public class BagTest {
    @Test
    public void testBag(){
        Bag bag = new HashBag();
        bag.add("apple");
        bag.add("banala");
        bag.add("orange");
        bag.add("apple");

        //不同元素的个数
        System.out.println(bag.uniqueSet().size());
        //apple出现的次数
        System.out.println(bag.getCount("apple"));
    }
}
