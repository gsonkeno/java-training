package com.gsonkeno.jdk.training.syntax.syntax;

import com.gsonkeno.jdk.training.syntax.TryCatch;
import org.junit.Test;

/**
 *
 * Created by gaosong on 2017-11-29
 * <ul>
 *     <li>try catch中字节码是如何跳变的？<a href="https://www.cnblogs.com/averey/p/4379646.html"> csdn链接</a></li>
 * </ul>
 */
public class TryCatchTest {

    @Test
    public void test1(){
        System.out.println(new TryCatch().aaa());
    }

}
