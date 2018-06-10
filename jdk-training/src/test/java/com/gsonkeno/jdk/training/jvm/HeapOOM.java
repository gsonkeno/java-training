package com.gsonkeno.jdk.training.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆内存溢出测试
 * VM args: -Xms20m  最小堆内存
 *          -Xmx20m  最大堆内存
 *          -XX:+HeapDumpOnOutOfMemoryError  虚拟机出现内存溢出异常时Dump出当前的内存堆转储快照以便事后分析
 *          XX:HeapDumpPath=./java_pid.hprof来显示指定路径
 * Created by gaosong on 2018-03-25
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
