package com.pp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pp.pojo.Books;

import com.pp.service.IBookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "Library Management API",description = "API is to Store books and BookLoan status management")
public class LibraryController {
	

	@Autowired
	public IBookService serviceBook;
	
	@Operation(summary = "POST Operation ", description = "It will accept One Book Object and Stores in the database ")
	@PostMapping("/booksave")
	public ResponseEntity<Books> storeBook(@RequestBody Books book){
	 Books storedBook  = serviceBook.takeBook(book);
	 System.out.println(storedBook);
		 String msg="book Stored Successfully";
		
		
		return  new ResponseEntity<Books>(storedBook,HttpStatus.OK);
	}
	
	
	@Operation(summary = "POST Operation ", description = "It will accept  the books  and returns a message ")
	@PostMapping("/bookallsave")
	public ResponseEntity<String> storeSetBook(@RequestBody List<Books> book){
	  List<Books> StoredSetBooks = serviceBook.storeSetOfBooks(book);
	 System.out.println(StoredSetBooks);
		 String msg=" the set of book are  Stored Successfully";
		
		
		return  new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@Operation(summary = "GET Operation ", description = "it  returns All the books present in the database")
	@GetMapping("/getAllBooks")
	public ResponseEntity<?> findall(){
	
		
		List<Books> list = serviceBook.fetchAll();
	return new  ResponseEntity<List<Books>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getBookByGenre/{genre}")
	@Operation(summary = "GET Operation ", description = "It will accept Genre name of String  and returns List of books with Accepted genre type")
	public ResponseEntity<?> findByGenere(@PathVariable String genre ){
	
		
		List<Books> listGenre = serviceBook.getByGenre(genre);
	return new  ResponseEntity<List<Books>>(listGenre,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	@Operation(summary = "delete Operation ", description = "deletes the data by bookId")
	public ResponseEntity<?> delete(@PathVariable Integer id ){
	
		
		String msg = serviceBook.deleteBook(id);
	return new  ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	
	
	
	
	
	
}