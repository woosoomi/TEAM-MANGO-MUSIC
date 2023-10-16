package com.itwill.jpa.dto.cart;

import com.itwill.jpa.dto.OrderDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartDto {
	
	private int cartNo;
	
	private int cartQty;
}
