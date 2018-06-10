package com.gsonkeno;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        while (true){
            logger.info("Hello World log4j-training2");
            System.out.println( "Hello World!" );
        }
    }
}
