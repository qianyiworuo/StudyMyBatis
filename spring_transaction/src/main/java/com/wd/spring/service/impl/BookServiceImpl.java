package com.wd.spring.service.impl;

import com.wd.spring.dao.BookDao;
import com.wd.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer customerId, Integer bookId) {
        //查询图书的价格
        Integer price = bookDao.getBookPriceById(bookId);
        //更新图书库存
        bookDao.updateStockById(bookId);
        //更新顾客余额
        bookDao.updateBalance(customerId, price);
    }
}
