package com.gsonkeno;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Map;
import java.util.Properties;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public static void main(String[] args) {
        Properties properties = System.getProperties();

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "  ->  " + entry.getValue());
        }

        Map<String, String> getenv = System.getenv();

        for (Map.Entry<String, String> entry : getenv.entrySet()) {
            System.out.println(entry.getKey() + "  ->   " + entry.getValue());
        }
    }
}
