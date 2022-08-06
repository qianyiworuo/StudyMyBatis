package com.wd.mybatis.test;

import com.wd.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void insertUserTest() throws IOException {
        //输入流获取核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取MyBatis中执行sql语句SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory对象MyBatis提供操作数据库的对象
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession对象
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取UserMapper代理实现类对象(代理模式创建mapper接口的实现类，再由实现类创建mapper接口的实现类对象)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用mapper接口中的方法
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        if(result > 0){
            //提交事务
            sqlSession.commit();
        }
        System.out.println("结果：" + result);
        //关闭sqlSession对象
        sqlSession.close();

    }
}
