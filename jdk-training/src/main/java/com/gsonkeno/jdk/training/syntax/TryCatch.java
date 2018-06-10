package com.gsonkeno.jdk.training.syntax;

/**
 * Created by gaosong on 2017-11-29
 */
public class TryCatch {
    public int aaa() {
        int x = 1;
        try {
            return ++x;
        } catch (Exception e) {
        } finally {
            ++x;
        }
        return x;
    }
}
