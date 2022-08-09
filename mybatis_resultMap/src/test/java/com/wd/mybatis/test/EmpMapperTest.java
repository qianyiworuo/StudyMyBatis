package com.wd.mybatis.test;

import com.wd.mybatis.mapper.EmpMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {
    @Test
    public void getAllEmpTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> empList = mapper.getAllEmp();
        if (empList != null){
            empList.forEach(System.out::println);
        }
    }
    @Test
    public void getEmpAndDeptByEmpIdTest() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByEmpId(1);
        if (emp != null) {
            System.out.println(emp);
        }
    }
}
