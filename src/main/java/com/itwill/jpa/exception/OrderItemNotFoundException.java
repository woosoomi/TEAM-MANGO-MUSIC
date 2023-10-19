package com.itwill.jpa.exception;

public class OrderItemNotFoundException extends IllegalStateException{

	public OrderItemNotFoundException(String message) {
		super(message);
	}
	
}
