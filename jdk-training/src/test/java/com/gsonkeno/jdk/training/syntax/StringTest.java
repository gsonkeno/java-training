package com.gsonkeno.jdk.training.syntax.syntax;

import org.junit.Test;

/**
 * Created by gaosong on 2017-11-29<br>
 *  <ul>
 *   <li>String是基本类型吗？为什么可以+操作</li>
 *  </ul>
 *
 */
public class StringTest {

    // 运算符+在字符串处理过程中底层jvm做了运算符重载功能
    @Test
    public void testPlus(){
        String s = "a";
        String t = "b";

        String m = s + t;
        System.out.println(m);
    }

    @Test
    public void  testEquals(){
        String a = "m";
        String b = "m";
        System.out.println(a == b); //true

        String  s = new String("j");
        String  t = new String("j");
        System.out.println(s == t);// false

        String c = "lks";
        String d = new String("lks");
        System.out.println(c == d); //false

        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");

    }

    @Test
    public void testIntern(){
        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");

        String s2= new String("abc"); //会在常量池创建字符串常量abc  和堆中创建字符串abc
        String s1="abc";

        System.out.println(s1.intern() == s2);
    }

    /**
     * 参考文章 http://blog.csdn.net/seu_calvin/article/details/52291082
     */
    @Test
    public void testIntern1(){
        String str2 = "SEUCalvin";//新加的一行代码，其余不变
        String str1 = new String("SEU")+ new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1.intern() == str2);
        System.out.println(str1 == "SEUCalvin");
    }
}
