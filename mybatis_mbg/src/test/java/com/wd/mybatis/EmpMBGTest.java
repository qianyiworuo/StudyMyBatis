package com.wd.mybatis;

import com.wd.mybatis.mapper.EmpMapper;
import com.wd.mybatis.pojo.Emp;
import com.wd.mybatis.pojo.EmpExample;
import com.wd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpMBGTest {
    @Test
    public void getEmpByIdTest(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //根据Id查询
//        Emp emp = mapper.selectByPrimaryKey(1);
//        if(emp != null){
//            System.out.println(emp);
//            sqlSession.close();
//        }
        //查询所有数据
//        List<Emp> emps = mapper.selectByExample(null);
//        if (emps != null){
//            emps.forEach(System.out::println);
//            sqlSession.close();
//        }
        //根据条件查询数据
//        EmpExample empExample = new EmpExample();
//        empExample.createCriteria().andEmpNameEqualTo("张三");
//        empExample.or().andGenderEqualTo("男");
//        List<Emp> emps = mapper.selectByExample(empExample);
//        if (emps != null){
//            emps.forEach(System.out::println);
//            sqlSession.close();
//        }
        //测试修改功能(选择性)
        Emp emp = new Emp();
        emp.setEmpId(1);
        emp.setEmpName("小红");
        emp.setGender("女");
        int update = mapper.updateByPrimaryKeySelective(emp);
        if(update > 0){
            System.out.println("修改成功");
            sqlSession.close();
        }

    }
}
