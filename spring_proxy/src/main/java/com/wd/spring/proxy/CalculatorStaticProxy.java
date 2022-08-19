package com.wd.spring.proxy;

public class CalculatorStaticProxy implements Calculator{
    private Calculator calculator;

    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        int add = 0;
        try {
            System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);
            add = calculator.add(i, j);
            System.out.println("[日志] add 方法结束了，结果是：" + add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return add;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("[日志] sub 方法开始了，参数是：" + i + "," + j);
        int sub = calculator.sub(i, j);
        System.out.println("[日志] sub 方法结束了，结果是：" + sub);
        return sub;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("[日志] mul 方法开始了，参数是：" + i + "," + j);
        int mul = calculator.mul(i, j);
        System.out.println("[日志] mul 方法结束了，结果是：" + mul);
        return mul;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("[日志] div 方法开始了，参数是：" + i + "," + j);
        int div = calculator.div(i, j);
        System.out.println("[日志] div 方法结束了，结果是：" + div);
        return div;
    }
}
