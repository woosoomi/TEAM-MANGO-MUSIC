package com.itwill.jpa.dto.cart;


import java.util.List;

import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;

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
	
	private Long cartId;
	private int cartTotPrice;
	private String userId;
	private CartItem cartItem;
	
	public static CartDto toDto(Cart entity) {
		return CartDto.builder()
						.cartId(entity.getCartId())
						.cartTotPrice(entity.getCartTotPrice())
						.userId(entity.getUser().getUserId())
						.build();
	}
	
	
	
	
	
}
