package com.gsonkeno.json;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * google 的json测试
 */
public class GSONTest {

    /**
     * 模型对象转json字符串
     * gson.toJson(model)
     */
    @Test
    public void testObj2Json(){
        Gson gson = new Gson();
        Student student = new Student();
        student.setAge(5);
        student.setId(7);
        student.setName("hey");
        student.setSex("男");

        String s = gson.toJson(student);
        System.out.println(s);
    }

    /**
     * json字符串转模型对象
     * gson.fromJson(s, Model.class)
     */
    @Test
    public void testJsonStr2Obj(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","hello");
        map.put("sex","男");
        map.put("age",1);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        System.out.println(s);

        Student student = gson.fromJson(s, Student.class);
        System.out.println(student);

        Student1 student1 = gson.fromJson(s, Student1.class);
        System.out.println(student1);
    }
}
