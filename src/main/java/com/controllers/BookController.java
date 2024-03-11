package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.models.Book;
import com.services.BookService;

@RestController
@RequestMapping(path = "/book")
class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    private List<Book> getAllBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("/{bookId}")
    private Book getBook(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("")
    private int saveBook(@RequestBody Book book) {
        bookService.saveBook(book);
        return book.getBookId();
    }

    @DeleteMapping("/{bookId}")
    private void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping("/{bookId}")
    private Book update(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        bookService.updateBook(book, bookId);
        return book;
    }
}
