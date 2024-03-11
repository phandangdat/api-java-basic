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

import com.models.Author;
import com.services.AuthorService;

@RestController
@RequestMapping(path = "/author")
public class AuthorController {
  @Autowired
  private AuthorService authorService;

  @GetMapping("")
  private List<Author> getAllAuthor() {
    return authorService.getAllAuthor();
  }

  @GetMapping("/{authorId}")
  private Author getAuthor(@PathVariable("authorId") int authorId) {
    return authorService.getAuthorById(authorId);
  }

  @PostMapping("")
  private int saveAuthor(@RequestBody Author author) {
    authorService.saveAuthor(author);
    return author.getAuthorId();
  }

  @DeleteMapping("/{authorId}")
  private void deleteAuthor(@PathVariable("authorId") int authorId) {
    authorService.delete(authorId);
  }

  @PutMapping("/{authorId}")
  private Author update(@RequestBody Author author, @PathVariable("authorId") int authorId) {
    authorService.update(author, authorId);
    return author;
  }
}
