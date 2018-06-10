package com.gsonkeno.jdk.training.regex;

/**
 * Created by gaosong on 2017-08-27
 */
public class RegexUse {
    public static void main(String[] args) {
        String str = "org/apache/commons/lang/WordUtils.class";
        System.out.println(str.matches(String.format("^(%s)[^/]+(\\.class)$","org/apache/commons/lang/")));
    }
}
