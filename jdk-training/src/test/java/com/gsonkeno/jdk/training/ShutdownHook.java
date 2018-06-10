package com.gsonkeno.aop.spring.aop.aspectj.aop.training.jdk.training.syntax;

import java.io.File;
import java.io.IOException;

/**
 * Created by gaosong on 2017-09-24
 */
public class ShutdownHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run()
            {
               // System.out.println("Execute Hook.....");
                File file = new File("test.txt");
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));

        while (true){

        }
    }
}
