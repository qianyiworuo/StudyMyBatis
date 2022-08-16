package com.wd.spring.test;

import com.wd.spring.pojo.Clazz;
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
    @Test
    public void studentThreeDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentThree", Student.class);
        System.out.println(student);
    }
    @Test
    public void studentFourID(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentFour", Student.class);
        System.out.println(student);
    }
    @Test
    public void studentFiveID(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentFive", Student.class);
        System.out.println(student);
    }
    @Test
    public void studentSixID(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentSix", Student.class);
        System.out.println(student);
    }
    @Test
    public void clazzOneDI(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Clazz clazz = ioc.getBean("clazzOne", Clazz.class);
        System.out.println(clazz);
    }
    @Test
    public void studentSevenID(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentSeven", Student.class);
        System.out.println(student);
    }
}
