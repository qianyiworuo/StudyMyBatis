package com.wd.spring.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class JdbcTest {
    @Test
    public void test() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean("dataSource",DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }
    @Test
    public void DruidTest() throws SQLException {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource dataSource = ioc.getBean("druidDataSource",DruidDataSource.class);
        System.out.println(dataSource.getConnection());
    }

}
