package com.gsonkeno.jdk.training.syntax;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by gaosong on 2017-12-06
 */
public class DecimalTest {

    @Test
    public void testDecimal(){
        DecimalFormat format = new DecimalFormat("000");
        System.out.println(format.format(5));
    }
}
