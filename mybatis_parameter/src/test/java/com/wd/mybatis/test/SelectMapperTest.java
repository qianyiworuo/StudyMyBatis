package com.wd.mybatis.test;

import com.wd.mybatis.mapper.SelectMapper;
import com.wd.mybatis.mapper.UserMapper;
import com.wd.mybatis.pojo.User;
import com.wd.mybatis.utils.sqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    @Test
    public void getUserByIdTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer id = 1;
        User user = mapper.getUserById(id);
        if (user != null) {
            System.out.println("查询结果：" + user);
            sqlSession.close();
        }
    }
    @Test
    public void getAllUserTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> userList = mapper.getAllUser();
        if (userList != null) {
            userList.forEach(System.out::println);
            sqlSession.close();
        }
    }
    @Test
    public void getCountTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        if (count != null) {
            System.out.println("查询结果：" + count);
            sqlSession.close();
        }
    }
    @Test
    public void getUserByMapTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer id = 1;
        Map<String, Object> map = mapper.getUserToMap(id);
        if (map != null) {
            System.out.println("查询结果：" + map);
            sqlSession.close();
        }
    }
    @Test
    public void getAllUserToListMapTest(){
        SqlSession sqlSession = sqlSessionUtil.getSqlSession("mybatis-config.xml", true);
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> listMap = mapper.getAllUserToListMap();
        if (listMap != null) {
            for (Map<String, Object> map: listMap) {
                int id = (int) map.get("id");
                System.out.println(id);
                System.out.println("======");
                Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String, Object> entry = iterator.next();
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.println(key+"="+value);
                }
            }
            //System.out.println("查询结果：" + listMap);
            sqlSession.close();
        }
    }
}
