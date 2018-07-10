package com.gsonkeno.util;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

public class ObjectTest {

    /**
     * 个人认为用处不大，如果是判断两个对象是否相等，完全可以用equal
     */
    @Test
    public void testNotEqual(){

        String s = null;
        System.out.println(null == s);
        System.out.println(ObjectUtils.notEqual(null,s));
        System.out.println(ObjectUtils.notEqual(s,null));

        System.out.println(ObjectUtils.compare(null,null));
    }

    /**
     * 判断两个对象之间的大小
     */
    @Test
    public void testCompare(){
        System.out.println(ObjectUtils.compare(null,null));
        System.out.println(ObjectUtils.compare(null,1));
        System.out.println(ObjectUtils.compare(null,1,false));
        System.out.println(ObjectUtils.compare(1,null));

    }

    /**
     * Object为空时取默认值
     */
    @Test
    public void testDefaultIfNull(){
        Object m = null;
        Object o = ObjectUtils.defaultIfNull(m, "");
        System.out.println(o);
    }


}
