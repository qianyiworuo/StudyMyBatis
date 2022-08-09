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
    public void fuzzyQueryByUsernameTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        String info = "j";
        List<User> userList = mapper.fuzzyQueryByUsername(info);
        if (userList != null) {
            userList.forEach(System.out::println);
            sqlSession.close();
        }
    }
    @Test
    public void deleteBatchUserTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        String ids = "4,6";
        int result = mapper.deleteBatchUser(ids);
        if (result > 0) {
            System.out.println("删除成功"+ result);
            sqlSession.close();
        }
    }
    @Test
    public void getAllUserTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        String tableName = "t_user";
        List<User> userList = mapper.getAllUser(tableName);
        if (userList != null) {
            userList.forEach(System.out::println);
            sqlSession.close();
        }
    }
    @Test
    public void insertUserTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(null, "Jerry", "xdr456", 6, "男", "jerry@qq.com");
        mapper.insertUser(user);
        System.out.println(user.getId());

    }


}
