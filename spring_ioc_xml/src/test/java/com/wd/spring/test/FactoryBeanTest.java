package com.wd.spring.test;

import com.wd.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-factorybean.xml");
        User user = ioc.getBean(User.class);
        System.out.println(user);
    }
}
