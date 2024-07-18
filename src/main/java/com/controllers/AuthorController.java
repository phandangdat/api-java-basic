package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    return author.getId();
  }

  @DeleteMapping("/{authorId}")
  private void deleteAuthor(@PathVariable("authorId") int authorId) {
    authorService.delete(authorId);
  }

  @PatchMapping("/{authorId}")
  private ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable("authorId") int authorId) {
    Author updatedAuthor = authorService.updateAuthor(author, authorId);
    return ResponseEntity.ok(updatedAuthor);
  }
}
