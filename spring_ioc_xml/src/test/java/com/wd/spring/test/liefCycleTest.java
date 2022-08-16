package com.wd.spring.test;

import com.wd.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class liefCycleTest {
    @Test
    public void testLife(){
        ConfigurableApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User bean = ac.getBean(User.class);
        System.out.println("生命周期：4、通过IOC容器获取bean并使用："+ bean);
        ac.close();
    }

}
