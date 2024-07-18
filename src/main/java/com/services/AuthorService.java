package com.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Author;
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

  public void saveAuthor(Author author) {
    authorRepository.save(author);
  }

  public void delete(int id) {
    authorRepository.deleteById(id);
  }

  public Author updateAuthor(Author author, int id) {
    Optional<Author> optionalAuthor = authorRepository.findById(id);

    if (!optionalAuthor.isPresent()) {
      throw new RuntimeException("User not found with id " + id);
    }

    Author existingAuthor = optionalAuthor.get();

    if (author.getEmail() != null) {
      existingAuthor.setEmail(author.getEmail());
    }

    if (author.getFirstName() != null) {
      existingAuthor.setFirstName(author.getFirstName());
    }

    if (author.getLastName() != null) {
      existingAuthor.setLastName(author.getLastName());
    }

    if (author.getAvatar() != null) {
      existingAuthor.setAvatar(author.getAvatar());
    }
    return authorRepository.save(existingAuthor);
  }
}
