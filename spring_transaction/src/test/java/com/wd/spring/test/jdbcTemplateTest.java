package com.wd.spring.test;

import com.wd.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//指定当前测试类在Spring的测试环境中执行，此时就可以通过注入的方式直接获取IOC容器中的Bean
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring测试环境的配置文件
@ContextConfiguration("classpath:spring-jdbctemplate.xml")
public class jdbcTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void insertTest(){
        String sql = "INSERT INTO t_user (id, username, password, age, gender, email)VALUES(null,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql, "李四", "1234", 22, "女", "ls@qq.com");
        if(result > 0){
            System.out.println("新增成功："+ result);
        }
    }
    @Test
    public void updateTest(){
        String sql = "UPDATE t_user SET email = ? WHERE id = ?";
        int result = jdbcTemplate.update(sql, "lisi@qq.com", 9);
        if(result > 0){
            System.out.println("修改成功："+ result);
        }
    }
    @Test
    public void deleteTest(){
        String sql = "DELETE FROM t_user WHERE id = ?";
        int result = jdbcTemplate.update(sql, 9);
        if(result > 0){
            System.out.println("删除成功："+ result);
        }
    }
    //查询一条数据为一个实体类对象
    @Test
    public void queryOneDataTest(){
        String sql = "SELECT id, username, password, age, gender, email FROM t_user WHERE id = ?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 1);
        if(user != null){
            System.out.println(user);
        }
    }
    //查询多条数据为一个list集合
    @Test
    public void queryMoreDataTest(){
        String sql = "SELECT id, username, password, age, gender, email FROM t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        if(userList != null){
            userList.forEach(System.out::println);
        }
    }
    //查询单行单列的值
    @Test
    public void countTest(){
        String sql = "SELECT count(id) FROM t_user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        if(count >= 0){
            System.out.println(count);
        }
    }
}
