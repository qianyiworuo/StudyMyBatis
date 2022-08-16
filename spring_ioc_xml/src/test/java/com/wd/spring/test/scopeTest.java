package com.wd.spring.test;

import com.wd.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class scopeTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-scope.xml");
        Student student = ioc.getBean(Student.class);
        Student student1 = ioc.getBean(Student.class);
        System.out.println(student == student1);
    }

}
