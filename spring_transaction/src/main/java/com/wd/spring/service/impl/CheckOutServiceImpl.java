package com.wd.spring.service.impl;

import com.wd.spring.service.BookService;
import com.wd.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    private BookService bookService;
    @Override
    @Transactional
    public void checkOut(Integer customerId, Integer[] bookIds) {
        for(Integer bookId : bookIds){
            bookService.buyBook(customerId, bookId);
        }
    }
}
