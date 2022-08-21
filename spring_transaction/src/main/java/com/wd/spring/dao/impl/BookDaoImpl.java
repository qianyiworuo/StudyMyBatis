package com.wd.spring.dao.impl;

import com.wd.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getBookPriceById(Integer bookId) {
        String sql = "SELECT price FROM t_book WHERE book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    @Override
    public void updateStockById(Integer bookId) {
        String sql = "UPDATE t_book SET stock = stock - 1 WHERE book_id = ?";
        jdbcTemplate.update(sql, bookId);

    }

    @Override
    public void updateBalance(Integer customerId, Integer price) {
        String sql = "UPDATE t_customer SET balance = balance - ? WHERE customer_id = ?";
        jdbcTemplate.update(sql, price, customerId);

    }
}
