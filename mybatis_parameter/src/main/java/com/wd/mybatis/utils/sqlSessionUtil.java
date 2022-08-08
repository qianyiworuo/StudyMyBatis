package com.wd.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class sqlSessionUtil {
    public static SqlSession getSqlSession(String resource, boolean isCommit) {
        SqlSession sqlSession = null;
        //输入流获取核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
            //获取MyBatis中执行sql语句SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            //获取SqlSessionFactory对象MyBatis提供操作数据库的对象
            //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            if(isCommit){
                sqlSession = sessionFactory.openSession(true);
            }else {
                sqlSession = sessionFactory.openSession();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
