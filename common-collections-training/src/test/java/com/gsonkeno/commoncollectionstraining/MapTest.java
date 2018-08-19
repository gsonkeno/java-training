package com.gsonkeno.commoncollectionstraining;

import org.apache.commons.collections.map.LRUMap;
import org.junit.Test;

public class MapTest {

    @Test
    public void testLRUMap(){
        LRUMap lruMap = new LRUMap(4);
        lruMap.put("A",1);
        lruMap.put("B",2);

        //get操作会将A元素移动至链表的头部
        lruMap.get("A");
        lruMap.put("C",3);
        lruMap.put("D",4);
        lruMap.put("E",5);
        System.out.println(lruMap);
    }
}
