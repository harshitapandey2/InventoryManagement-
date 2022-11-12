package com.genc.InventoryManagement.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomException {
	@ExceptionHandler(value = ProductNotFoundException.class)
	   public ResponseEntity<ExceptionResponse> productNotFoundException(ProductNotFoundException exception) {
	      return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(),"Product not found"), HttpStatus.NOT_FOUND);
	   }
	@ExceptionHandler(value = CategoryMismatchException.class)
	public ResponseEntity<ExceptionResponse> categoryMismatchException(CategoryMismatchException exception) {
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(),"Category Incorrect"), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = DuplicateProductFoundException.class)
	public ResponseEntity<ExceptionResponse> duplicateProductException(DuplicateProductFoundException exception) {
		return new ResponseEntity<ExceptionResponse>(new ExceptionResponse(LocalDateTime.now(),"Duplicate product"), HttpStatus.BAD_REQUEST);
	}
	
}
