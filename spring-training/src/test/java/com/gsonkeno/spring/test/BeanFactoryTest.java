package com.gsonkeno.spring.test;

import com.gsonkeno.spring.bean.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by gaosong on 2018-04-02
 */
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanFactoryTest.xml"));
        MyTestBean myTestBean = (MyTestBean)bf.getBean("myTestBean3");
        System.out.println(myTestBean.getTestStr());
    }
}
