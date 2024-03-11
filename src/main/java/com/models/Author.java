package com.models;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_id")
  private int AuthorId;

  @Column(name = "name")
  private String Name;

  @OneToMany(mappedBy = "Author")
  private Set<Book> Books = new HashSet<>();

  public int getAuthorId() {
    return AuthorId;
  }

  public void setAuthorId(int authorId) {
    AuthorId = authorId;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public Set<Book> getBooks() {
    return Books;
  }

  public void setBooks(Set<Book> books) {
    this.Books = books;
  }
}
