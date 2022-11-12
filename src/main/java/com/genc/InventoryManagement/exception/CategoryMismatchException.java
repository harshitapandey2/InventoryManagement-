package com.genc.InventoryManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CategoryMismatchException extends RuntimeException {

	public CategoryMismatchException(String message) {
		super(message);
		
	}

}
