package com.wd.mybatis.test;

import com.wd.mybatis.mapper.DynamicSQLMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void getEmpByConditionTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,"",null,"男");
        List<Emp> empList = mapper.getEmpByCondition(emp);
        empList.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void insertBatchEmpTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null, "小明", 18, "男");
        Emp emp1 = new Emp(null, "李华", 19, "男");
        Emp emp2 = new Emp(null, "小倩", 20, "女");
        Emp emp3 = new Emp(null, "王强", 21, "男");
        List<Emp> emps = Arrays.asList(emp, emp1, emp2, emp3);
        mapper.insertBatchEmp(emps);
        sqlSession.close();
    }
    @Test
    public void deleteBatchEmpTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Integer[] empIds = new Integer[]{5};
        mapper.deleteBatchEmp(empIds);
        sqlSession.close();
    }
}
