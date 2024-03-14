package com.pp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pp.dao.BookRepository;
import com.pp.pojo.Books;
@Service
public class BookServiceImpl  implements IBookService {
	@Autowired
private BookRepository repository;

@Override
public Books takeBook(Books book) {
	
	return repository.save(book);
}

@Override
public List<Books> storeSetOfBooks(List<Books> books) {
	// TODO Auto-generated method stub
	return repository.saveAll(books);
}

@Override
public List<Books> fetchAll() {
	// TODO Auto-generated method stub
	return repository.findAll();

}

@Override
public List<Books> getByGenre(String genre) {
	// TODO Auto-generated method stub
	return repository.findByGenre(genre);
}

@Override
public String deleteBook(Integer bookId) {
	// TODO Auto-generated method stub
 Optional<Books> opt = repository.findById(bookId);
 if(opt.isPresent()){
	 repository.delete(opt.get());
	 return "deleted";
 }
 return "failed to delete";
}




}
