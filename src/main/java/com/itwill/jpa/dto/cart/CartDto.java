package com.itwill.jpa.dto.cart;


import java.util.List;

import com.itwill.jpa.entity.user.User;

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
	private int cartTotPrice;
	//private List<CartItemDto> cartItems;
}
