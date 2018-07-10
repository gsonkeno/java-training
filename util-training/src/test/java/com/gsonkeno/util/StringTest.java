package com.gsonkeno.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringTest {

    /**
     * String为"空"时取默认值
     */
    @Test
    public void testDefault(){
        String m = null;
        String n = "";
        String t = "\r\n";
        String r = " \t";
        String s = " ";
        //String为null时返回""
        System.out.println(StringUtils.defaultString(m));

        //String为null是返回defaultStr
        System.out.println(StringUtils.defaultString(m,"a"));

        //String为null或长度为0时返回defaultStr
        System.out.println(StringUtils.defaultIfEmpty(n,"b"));
        System.out.println(StringUtils.defaultIfEmpty(t,"c"));

        //String为null或长度为0或内部有空字符时，返回defaultStr
        System.out.println(StringUtils.defaultIfBlank(r,"d"));
        System.out.println(StringUtils.defaultIfBlank(s,"d1"));

    }
}
