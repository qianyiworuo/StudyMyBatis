package com.wd.spring.aop.annotation;

import org.junit.Test;

import java.util.Scanner;

public class ProxyTest {
    @Test
    public void test(){
        Calculator calculator = new CalculatorImpl();
        CalculatorStaticProxy calculatorStaticProxy = new CalculatorStaticProxy(calculator);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int i = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int j = scanner.nextInt();
        calculatorStaticProxy.add(i, j);
    }
    @Test
    public void dynamicProxyTest(){
        Calculator calculator = new CalculatorImpl();
        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数字");
        int i = scanner.nextInt();
        System.out.println("请输入第二个数字");
        int j = scanner.nextInt();
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(i,j);
    }
}
