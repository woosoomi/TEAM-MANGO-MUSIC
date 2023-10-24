package com.itwill.jpa.service.cart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;

import jakarta.transaction.Transactional;

class CartItemServiceImplTest extends TeamProjectMangoApplicationTest{

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void cartItemInsert() {
		Cart cart = Cart.builder()
							.cartId(0L)
							.cartTotPrice(1000)
							.build();
		
		CartItem cartItem = CartItem.builder()
									.cartItemId(0L)
									.cartItemQty(100)
									.build();
		
	
		
		CartItem insertCart = cartItemServiceImpl.insert(cartItem);
		System.out.println("insert>>>>>>>>>>>>>>>>>>"+insertCart);
	}

}
