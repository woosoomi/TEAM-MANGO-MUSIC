package com.itwill.jpa.exception;

public class OutOfStockException extends RuntimeException{
	
	public OutOfStockException(String message) {
		super(message);
	}
}
