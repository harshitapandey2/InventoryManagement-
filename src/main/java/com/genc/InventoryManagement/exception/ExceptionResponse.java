package com.genc.InventoryManagement.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ExceptionResponse {
	private LocalDateTime date;
	private String message;
	
	
	public ExceptionResponse(LocalDateTime date, String message) {
		super();
		this.date = date;
		this.message = message;
	}
	public ExceptionResponse() {
	}
	
	
}
