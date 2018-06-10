package com.gsonkeno.jdk.training.reflect;

/**
 * Created by gaosong on 2017-09-01
 */
public class RainTest {
    public static void main(String[] args) {
        Atmosphere rain = RainManage.createRain();
        rain.behave();
    }
}
