package com.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private int BookID;

  @Column(name = "title")
  private String Title;

  @Column(name = "author")
  private String Author;

  @Column(name = "publication_year")
  private LocalDateTime PublicationYear;

  @Column(name = "available")
  private boolean Available;

  public Book() {
  }

  public Book(int BookID, String Title, String Author, LocalDateTime PublicationYear, boolean Available) {
    this.BookID = BookID;
    this.Title = Title;
    this.Author = Author;
    this.PublicationYear = PublicationYear;
    this.Available = Available;
  }

  public long getBookID() {
    return BookID;
  }

  public void setBookID(int BookID) {
    this.BookID = BookID;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String Title) {
    this.Title = Title;
  }

  public String getAuthor() {
    return Author;
  }

  public void setAuthor(String Author) {
    this.Author = Author;
  }

  public LocalDateTime getPublicationYear() {
    return PublicationYear;
  }

  public void setPublicationYear(LocalDateTime PublicationYear) {
    this.PublicationYear = PublicationYear;
  }

  public boolean isAvailable() {
    return Available;
  }

  public void setAvailable(boolean Available) {
    this.Available = Available;
  }
}
