package com.gsonkeno.util;

public class AssertT {

    private Boolean m = null;

    public AssertT(){
        assert  m =  true;
        System.out.println(m);

    }
    public static void main(String[] args) {
        System.out.println(new AssertT());
    }

}
