package com.gsonkeno.commoncollectionstraining;

import org.apache.commons.collections.list.GrowthList;
import org.apache.commons.collections.list.SetUniqueList;
import org.junit.Test;

import java.util.ArrayList;

public class GrowthListTest {
    @Test
    public void test(){
        GrowthList growthList = new GrowthList();
        System.out.println("list size" + growthList.size());
        growthList.add(200,1);
        System.out.println("list size" + growthList.size());

        //不会有重复元素的列表
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("name");
        arrayList.add("name");
        arrayList.add("age");
        arrayList.add("sex");
        SetUniqueList decorateList = SetUniqueList.decorate(arrayList);
        System.out.println(decorateList);
    }
}
