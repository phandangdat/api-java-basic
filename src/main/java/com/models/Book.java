package com.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private int BookId;

  @Column(name = "title")
  private String Title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author Author;

  @Column(name = "publication_year")
  private LocalDateTime PublicationYear;

  @Column(name = "available")
  private boolean Available;

  public Book() {
  }

  public Book(int BookId, String Title, Author Author, LocalDateTime PublicationYear, boolean Available) {
    this.BookId = BookId;
    this.Title = Title;
    this.Author = Author;
    this.PublicationYear = PublicationYear;
    this.Available = Available;
  }

  public int getBookId() {
    return BookId;
  }

  public void setBookId(int BookId) {
    this.BookId = BookId;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String Title) {
    this.Title = Title;
  }

  public Author getAuthor() {
    return Author;
  }

  public void setAuthor(Author Author) {
    this.Author = Author;
  }

  public LocalDateTime getPublicationYear() {
    return PublicationYear;
  }

  public void setPublicationYear(LocalDateTime PublicationYear) {
    this.PublicationYear = PublicationYear;
  }

  public boolean getAvailable() {
    return Available;
  }

  public void setAvailable(boolean Available) {
    this.Available = Available;
  }
}
