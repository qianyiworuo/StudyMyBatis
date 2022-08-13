package com.wd.mybatis.test;

import com.wd.mybatis.mapper.CacheMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class CacheMapperTest {
    @Test
    public void getEmpByIdTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(2);
        if (emp != null){
            System.out.println(emp);
        }
        Emp emp1 = mapper.getEmpById(2);
        System.out.println(emp.hashCode() +"一级缓存"+ emp1.hashCode());
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp2 = mapper1.getEmpById(2);
        System.out.println(emp.hashCode()+"一级缓存"+emp1.hashCode()+"新的缓存"+emp2.hashCode());
    }
    @Test
    public void getEmpByIdTestTwoCache(){
        SqlSessionFactory sqlSessionFactory = SqlSessionUtil.getSqlSessionFactory("mybatis-config.xml");
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        System.out.println(emp.hashCode());
        sqlSession.close();
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);
        System.out.println(emp1.hashCode());
        sqlSession1.close();
    }
}
