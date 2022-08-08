package com.wd.mybatis.test;

import com.wd.mybatis.mapper.SelectMapper;
import com.wd.mybatis.mapper.SpecialSqlMapper;
import com.wd.mybatis.pojo.User;
import com.wd.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class SpecialSqlMapperTest {
    @Test
    public void fuzzyQueryByUsername(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        String info = "j";
        List<User> userList = mapper.fuzzyQueryByUsername(info);
        if (userList != null) {
            userList.forEach(System.out::println);
            sqlSession.close();
        }
    }


}
