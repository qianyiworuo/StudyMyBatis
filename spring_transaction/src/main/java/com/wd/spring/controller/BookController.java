package com.wd.spring.controller;

import com.wd.spring.service.BookService;
import com.wd.spring.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CheckOutService checkOutService;
    public void buyBook(Integer customerId, Integer bookId){
        bookService.buyBook(customerId, bookId);
    }
    public void checkOut(Integer customerId, Integer[] booksIds){
        checkOutService.checkOut(customerId,booksIds);
    }
}
