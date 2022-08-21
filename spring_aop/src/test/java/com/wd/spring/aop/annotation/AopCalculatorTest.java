package com.wd.spring.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class AopCalculatorTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop_annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int i = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int j = scanner.nextInt();
        calculator.div(i,j);
    }
}
