package com.wd.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Before前置通知，在目标对象方法执行前执行
 * @After后置通知，在目标对象方法的finally字句中执行
 * @AfterReturning返回通知，在目标对象方法的返回值之后执行，若要获取目标对象方法的返回值，需要设置此注解的
 * returning属性的值，并且在此注解方法下设置参数，参数名要与属性的值一致。
 *      @AfterReturning(value = "pointCut()",returning = "result")
 *      public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result)
 * @AfterThrowing异常通知：在目标对象方法的catch字句中执行，若要获取目标对象方法的异常，需要设置此注解的
 * returning属性的值，并且在此注解方法下设置参数，参数名要与属性的值一致。
 *      @AfterThrowing(value = "pointCut()",throwing = "ex")
 *      public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex)
 *@Around环绕通知：环绕通知下的方法返回值必须要于目标方法的返回值一致
 *
 * 切入点表达式：设置在标识通知的注解的("")之中
 * @Before("execution(public int com.wd.spring.aop.annotation.CalculatorImpl.add(int, int))")
 * @Before("execution(* com.wd.spring.aop.annotation.CalculatorImpl.*(..))")
 * 第一个*表示任意的访问修饰符和返回值类型
 * 第二个*表示类中的任意方法
 * ..表示任意地参数列表
 * 类也可以使用*表示包下所有的类
 *
 * 获取切入点方法信息
 *  //获取连接点的方法名：signature.getName()
 * Signature signature = joinPoint.getSignature();
 * //获取点解点方法的参数
 * Object[] args = joinPoint.getArgs();
 * Arrays.toString(args));
 *
 * 重用切入点表达式
 * @Pointcut("execution(* com.wd.spring.aop.annotation.CalculatorImpl.*(..))")
 *  public void pointCut(){
 *  }
 *  使用方式
 *  @Before("pointCut()")
 */
@Component
@Aspect//@Aspect表示这个类是一个切面类
public class LoggerAspect {
    @Pointcut("execution(* com.wd.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){
    }
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点的方法名：signature.getName()
        Signature signature = joinPoint.getSignature();
        //获取点解点方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，前置通知，方法名："+signature.getName()+"，参数："+ Arrays.toString(args));
    }
    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点的方法名：signature.getName()
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，后置通知，方法名："+signature.getName()+"，执行完毕！");
    }
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result){
        //获取连接点的方法名：signature.getName()
        Signature signature = joinPoint.getSignature();
        //获取点解点方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，返回通知，方法名："+signature.getName()+"，参数："+ Arrays.toString(args)+"，结果："+ result);
    }
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable ex){
        //获取连接点的方法名：signature.getName()
        Signature signature = joinPoint.getSignature();
        //获取点解点方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，异常通知，方法名："+signature.getName()+"，参数："+ Arrays.toString(args)+"，异常："+ ex);

    }
    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            Signature signature = joinPoint.getSignature();
            //获取目标对象的方法名
            String methodName = signature.getName();
            //获取目标对象的参数
            Object[] args = joinPoint.getArgs();
            String parameters = Arrays.toString(args);
            System.out.println("环绕通知--->前置通知"+"，方法名："+methodName+"，参数："+parameters);
            //表示目标方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知--->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知--->异常通知");
        }finally {
            System.out.println("环绕通知--->后置通知");
        }
        return result;

    }
}
