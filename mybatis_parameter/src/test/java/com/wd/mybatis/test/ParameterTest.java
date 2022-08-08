package com.wd.mybatis.test;

import com.wd.mybatis.mapper.UserMapper;
import com.wd.mybatis.pojo.User;
import com.wd.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {
    @Test
    public void getUserByUsernameTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = "ljc";
        User user = mapper.getUserByUserName(username);
        if (user != null) {
            System.out.println("查询结果：" + user);
            sqlSession.close();
        }
    }
    @Test
    public void checkLoginTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = "ljc";
        String password = "12345";
        User user = mapper.checkLogin(username, password);
        if (user != null) {
            System.out.println("查询结果：" + user);
            sqlSession.close();
        }
    }
    @Test
    public void checkLoginByMapTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "ljc");
        map.put("password", "12345");
        User user = mapper.checkLoginByMap(map);
        if (user != null) {
            System.out.println("查询结果：" + user);
            sqlSession.close();
        }
    }
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("Niko");
        user.setPassword("123qwe");
        user.setAge(40);
        user.setGender("男");
        user.setEmail("niko@qq.com");
        int result = mapper.insertUser(user);
        if (result > 0) {
            System.out.println("执行结果：" + result);
            sqlSession.close();
        }
    }
    @Test
    public void checkLoginByParamTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = "ljc";
        String password = "12345";
        User user = mapper.checkLoginByParam(username, password);
        if (user != null) {
            System.out.println("查询结果：" + user);
            sqlSession.close();
        }
    }
}
