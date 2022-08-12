package com.wd.mybatis.test;

import com.wd.mybatis.mapper.DynamicSQLMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DynamicSQLMapperTest {
    @Test
    public void getEmpByConditionTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp(null,null,null, "男");
        List<Emp> empList = mapper.getEmpByCondition(emp);
        if(empList != null){
            empList.forEach(System.out::println);
        }
    }
}
