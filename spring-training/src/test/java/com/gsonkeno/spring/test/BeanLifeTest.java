package com.gsonkeno.spring.test;

import com.gsonkeno.spring.bean.life.MyBeanPostProcessor;
import com.gsonkeno.spring.bean.life.Person;
import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gaosong on 2018-04-03
 */
public class BeanLifeTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("开始初始化容器");
        ApplicationContext ac = new ClassPathXmlApplicationContext("Life.xml");

        System.out.println("xml加载完毕");
        Person person1 = (Person) ac.getBean("person1");
        System.out.println(person1);
        System.out.println("关闭容器");
        ((ClassPathXmlApplicationContext)ac).close();

//        开始初始化容器
//        PersonService类构造方法
//                set方法被调用
//        setBeanName被调用,beanName:person1
//                setBeanFactory被调用,beanFactory
//        setApplicationContext被调用
//                postProcessBeforeInitialization被调用
//        afterPropertiesSet被调用
//                myInit被调用
//        postProcessAfterInitialization被调用
//                xml加载完毕
//        name is :jack
//                关闭容器
//        destory被调用
//                myDestroy被调用

    }

    @Test
    public void testByBeanFactory(){
        System.out.println("开始初始化容器");
        ConfigurableBeanFactory bf = new XmlBeanFactory(new ClassPathResource("Life.xml"));
        System.out.println("xml加载完毕");
        //beanFactory需要手动注册beanPostProcessor类的方法
        bf.addBeanPostProcessor(new MyBeanPostProcessor());
        Person person1 = (Person) bf.getBean("person1");
        System.out.println(person1);
        System.out.println("关闭容器");
        bf.destroySingletons();

//        开始初始化容器
//        xml加载完毕
//                PersonService类构造方法
//        set方法被调用
//        setBeanName被调用,beanName:person1
//                setBeanFactory被调用,beanFactory
//        postProcessBeforeInitialization被调用
//                afterPropertiesSet被调用
//        myInit被调用
//                postProcessAfterInitialization被调用
//        name is :jack
//                关闭容器
//        destory被调用
//                myDestroy被调用
    }
}
