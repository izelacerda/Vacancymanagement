package com.mycarejs.vacancy_management.exceptions;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("user already exists");
  }
}
