package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Book;
import com.repositories.BookRepository;

@Service
public class BookService {
  @Autowired
  BookRepository bookRepository;

  public List<Book> getAllBook() {
    List<Book> books = new ArrayList<Book>();
    bookRepository.findAll().forEach(book1 -> books.add(book1));
    return books;
  }

  public Book getBookById(int id) {
    return bookRepository.findById(id).get();
  }

  @SuppressWarnings("null")
  public void saveBook(Book book) {
    bookRepository.save(book);
  }

  public void deleteBook(int id) {
    bookRepository.deleteById(id);
  }

  @SuppressWarnings("null")
  public void updateBook(Book book, int bookId) {
    bookRepository.findById(bookId).map(book1 -> {
      book1.setTitle(book.getTitle());
      book1.setAuthor(book.getAuthor());
      book1.setPublicationYear(book.getPublicationYear());
      book1.setAvailable(book.getAvailable());
      return bookRepository.save(book1);
    })
        .orElseGet(() -> {
          return bookRepository.save(book);
        });
    ;
  }
}
