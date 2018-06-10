package com.gsonkeno.jdk.training.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gaosong on 2017-09-24
 */
public class ReadWriteFile {

    public static void main(String[] args) throws IOException {
        String inFile = "inFile.txt";
        String outFile = "outFile.txt";

        FileInputStream fis = new FileInputStream(inFile);
        FileOutputStream fos = new FileOutputStream(outFile);

        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();

        ByteBuffer bf = ByteBuffer.allocate(1024);
        while (true){
            bf.clear();
            int read = inChannel.read(bf);

            if (read == -1) break;

            bf.flip();
            outChannel.write(bf);
        }
    }
}
