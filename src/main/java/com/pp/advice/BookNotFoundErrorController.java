package com.pp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pp.exception.BookNotFoundException;

@RestControllerAdvice
public class BookNotFoundErrorController {
     @ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> errorMsg(BookNotFoundException e){
		ErrorDetails errorDetails= new ErrorDetails("404 not found", e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.BAD_REQUEST);
	}
}
