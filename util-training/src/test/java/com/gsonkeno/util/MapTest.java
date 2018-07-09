package com.gsonkeno.util;

import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    public void test(){
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        LinkedHashMap<Object, Object> linkedHashMap = Maps.newLinkedHashMap();


    }

    @Test
    public void testTreeMap(){
        TreeMap<Comparable, Object> treeMap = Maps.newTreeMap();
        treeMap.put("2018-07-10",7);
        treeMap.put("2018-07-09",8);
        treeMap.put("2018-07-11",9);
        treeMap.put("2018-07-08",9);

        //iter快捷键
        for (Map.Entry<Comparable, Object> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }

        long longValue = MapUtils.getLongValue(treeMap, "2018-07-08", 0L);
        System.out.println(longValue);

    }
}
