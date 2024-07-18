package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Author;
import com.models.Book;
import com.repositories.AuthorRepository;

@Service
public class AuthorService {
  @Autowired
  AuthorRepository authorRepository;

  public List<Author> getAllAuthor() {
    List<Author> authors = new ArrayList<Author>();
    authorRepository.findAll().forEach(author -> authors.add(author));
    return authors;
  }

  public Author getAuthorById(int id) {
    return authorRepository.findById(id).get();
  }

  @SuppressWarnings("null")
  public void saveAuthor(Author author) {
    authorRepository.save(author);
  }

  public void delete(int id) {
    authorRepository.deleteById(id);
  }

  @SuppressWarnings("null")
  public void updateAuthor(Author author, int id) {
    authorRepository.findById(id).map(authorId -> {
      authorId.setEmail(author.getEmail());
      authorId.setFirstName(author.getFirstName());
      authorId.setLastName(author.getLastName());
      authorId.setAvatar(author.getAvatar());
      return authorRepository.save(authorId);
    })
        .orElseGet(() -> {
          return authorRepository.save(author);
        });
    ;
  }
}
