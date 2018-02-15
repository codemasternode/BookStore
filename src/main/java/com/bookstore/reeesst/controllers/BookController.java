package com.bookstore.reeesst.controllers;


import com.bookstore.reeesst.enties.Book;
import com.bookstore.reeesst.repositories.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @RequestMapping("")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

}
