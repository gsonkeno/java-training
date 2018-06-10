package com.gsonkeno.aop.spring.aop.aspectj.aop.training.jdk.training.syntax;

import java.io.*;

/**
 * Created by gaosong on 2017-09-24
 */
public class WriteFile {
    public static void main(String[] args) throws IOException {
        //writeByBuffer();
        writeByWriter();
    }

    private static void writeByOutputStream() throws IOException {
        File file = new File("add.txt");

        if (file.exists()) file.delete();
        file.createNewFile();

        FileOutputStream  out = new FileOutputStream(file);

        long begin = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {

            out.write("测试java 文件操作\r\n".getBytes());

        }

        out.close();
    }

    private static void writeByBuffer() throws IOException {
        File file = new File("add.txt");

        if (file.exists()) file.delete();
        file.createNewFile();

        FileOutputStream  out = new FileOutputStream(file);

        BufferedOutputStream bos = new BufferedOutputStream(out);

        for (int i = 0; i < 10000; i++) {

            bos.write("测试java 文件操作\r\n".getBytes());

        }

        //bos.flush();
        bos.close();
    }

    private static void writeByWriter() throws IOException {
        FileWriter fw = new FileWriter("add.txt",true);

        for (int i = 0; i < 100000; i++) {

            fw.write("测试java 文件操作\r\n");

        }

        fw.close();

    }
}
