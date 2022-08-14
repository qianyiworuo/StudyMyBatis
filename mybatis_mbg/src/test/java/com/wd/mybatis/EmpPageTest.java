package com.wd.mybatis;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.mybatis.mapper.EmpMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpPageTest {
    @Test
    public void pageTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询方法之前开启分页
        Page<Object> page = PageHelper.startPage(1, 2);
        List<Emp> emps = mapper.selectByExample(null);
        //查复方法后获取分页信息(navigatePages导航分页)
        PageInfo<Emp> pageInfo = new PageInfo<>(emps,2);
        if(emps != null){
            emps.forEach(System.out::println);
            System.out.println(page);
            System.out.println(pageInfo);
            sqlSession.close();
        }
    }

}
