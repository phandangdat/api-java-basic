package com.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int Id;

  @Column(name = "email")
  @Email(message = "Please input valid email!")
  private String Email;

  @Column(name = "first_name")
  @NotBlank(message = "First name should not be null!")
  private String FirstName;

  @Column(name = "last_name")
  @NotBlank(message = "Last name should not be null!")
  private String LastName;

  @Column(name = "avatar")
  private String Avatar;

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String name) {
    this.Email = name;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getAvatar() {
    return Avatar;
  }

  public void setAvatar(String avatar) {
    Avatar = avatar;
  }

  @Override
  public String toString() {
    return "Author [Id=" + Id + ", Email=" + Email + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Avatar="
        + Avatar + "]";
  }

}
