package com.gsonkeno.jdk.training.collection;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaosong on 2018-03-14
 */
public class HashMapTest {

    @Test
    public void test(){

        String jsonStr = "";

        try
        {
            FileReader fr = new FileReader("E:\\ideaProjects2017\\java-training\\jdk-training\\src\\test\\resources\\hashMap Dos攻击.txt");//需要读取的文件路径
            BufferedReader br = new BufferedReader(fr);
            jsonStr = br.readLine();
            br.close();
            fr.close();     //关闭文件流
        }catch(IOException e)
        {
            System.out.println("指定文件不存在");//处理异常
        }

        Map<String, Object> map = new HashMap<String, Object>();


        JSONObject jsonObject = new JSONObject();
        Object parse = JSONValue.parse(jsonStr);
    }

    //测试jdk1.8下的hashMap的put操作
    @Test
    public void testPut(){
        Map<String,Object> map = new HashMap<>();
        map.put("1","gaos");
        System.out.println(map);
    }
}
