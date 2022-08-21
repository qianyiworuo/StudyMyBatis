package com.wd.spring.dao;

public interface BookDao {
    Integer getBookPriceById(Integer bookId);

    void updateStockById(Integer bookId);

    void updateBalance(Integer customerId, Integer price);
}
