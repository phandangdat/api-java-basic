package com.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Book;

@RestController
@RequestMapping(path = "/api/v1/book")
class BookController {
    @GetMapping("/listBook")
    List<Book> getListBook() {
        return List.of(
            new Book(10, "Học làm giàu", "Đạt Phan", 1231232131, true)
        );
    };
}
