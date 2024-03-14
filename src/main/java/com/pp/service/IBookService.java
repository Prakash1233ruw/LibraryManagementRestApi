package com.pp.service;

import java.util.List;

import com.pp.dao.BookRepository;
import com.pp.pojo.Books;

public interface IBookService {
 public Books takeBook(Books book);
 public List<Books> storeSetOfBooks(List<Books> books);
 public List<Books>  fetchAll();
 public List<Books> getByGenre(String genre);
 public String deleteBook(Integer bookId);
}
