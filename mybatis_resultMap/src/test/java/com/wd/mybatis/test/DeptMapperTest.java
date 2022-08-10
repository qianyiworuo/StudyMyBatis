package com.wd.mybatis.test;

import com.wd.mybatis.mapper.DeptMapper;
import com.wd.mybatis.pojo.Dept;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeptMapperTest {
    @Test
    public void getDeptAndEmpByDeptId(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByDeptId(1);
        if(dept != null){
            System.out.println(dept);
        }
    }
}
