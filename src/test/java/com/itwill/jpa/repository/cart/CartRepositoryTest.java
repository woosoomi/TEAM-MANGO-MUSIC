package com.itwill.jpa.repository.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.dto.cart.CartItemDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.repository.user.UserRepository;

class CartRepositoryTest {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	//@Disabled
	void saveCartWithUser() {
		Cart cart = Cart.builder()
						.cartId(1L)
						.build();
	}


}
