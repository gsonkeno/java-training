package com.gsonkeno.commoncollectionstraining;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PredicateTest {

    @Test
    public void test(){
        //apache common collections的预测类
        Predicate predicate1 = new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return  Integer.valueOf(object.toString()) > 5;
            }
        };

        Predicate predicate2 = new Predicate() {
            @Override
            public boolean evaluate(Object object) {
                return  Integer.valueOf(object.toString()) < 15;
            }
        };

        List<String> list = new ArrayList<>();
        list.add("14");
        list.add("8");
        list.add("5");

        //过滤到不满足预测的元素
        CollectionUtils.filter(list,predicate1);
        System.out.println(list);

        //找到满足预测的第一个元素
        Object o = CollectionUtils.find(list, predicate2);
        System.out.println(o);


        //jdk的Predicate接口类
        java.util.function.Predicate<String> objectPredicate = new java.util.function.Predicate<String>() {
            @Override
            public boolean test(String o) {
                return false;
            }
        };

    }
}
