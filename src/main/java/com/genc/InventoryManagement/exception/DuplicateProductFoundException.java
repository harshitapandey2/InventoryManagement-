package com.genc.InventoryManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class DuplicateProductFoundException extends RuntimeException {

	public DuplicateProductFoundException(String message) {
		super(message);
		
	}

}
