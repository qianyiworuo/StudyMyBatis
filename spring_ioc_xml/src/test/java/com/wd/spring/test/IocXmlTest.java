package com.wd.spring.test;

import com.wd.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocXmlTest {
    @Test
    public void studentOne(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Student student = (Student) ioc.getBean("studentOne");
        //Student student = ioc.getBean(Student.class);
        Student student = ioc.getBean("studentOne", Student.class);
        System.out.println(student);
    }
    @Test
    public void studentTwoDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentTwo", Student.class);
        System.out.println(student);
    }
}
