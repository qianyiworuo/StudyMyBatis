package com.wd.spring.controller;

import com.wd.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    public void buyBook(Integer customerId, Integer bookId){
        bookService.buyBook(customerId, bookId);
    }
}
