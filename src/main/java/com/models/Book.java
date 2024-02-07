package com.models;

public class Book {
  private long BookID;
  private String Title;
  private String Author;
  private int PublicationYear;
  private boolean Available;

  public Book() {
  }

  public Book(long BookID, String Title, String Author, int PublicationYear, boolean Available) {
    this.BookID = BookID;
    this.Title = Title;
    this.Author = Author;
    this.PublicationYear = PublicationYear;
    this.Available = Available;
  }

  public long getBookID() {
    return BookID;
  }

  public void setBookID(long BookID) {
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

  public int getPublicationYear() {
    return PublicationYear;
  }

  public void setPublicationYear(int PublicationYear) {
    this.PublicationYear = PublicationYear;
  }

  public boolean isAvailable() {
    return Available;
  }

  public void setAvailable(boolean Available) {
    this.Available = Available;
  }
}
