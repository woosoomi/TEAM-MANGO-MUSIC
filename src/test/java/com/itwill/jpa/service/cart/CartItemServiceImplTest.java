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
import com.itwill.jpa.entity.user.User;

import jakarta.transaction.Transactional;

class CartItemServiceImplTest extends TeamProjectMangoApplicationTest {

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;

//	@Test
//	@Transactional
//	@Rollback(false)
	// @Disabled
//	void cartItemInsert() {
//		User user = new User("한영2", "11112", "한영2", "010-11112", "안양2", "why2", "9604102", "남", null, null, null, null);
//
//		CartItem cartItem = CartItem.builder().cartItemId(0L).cartItemQty(100).build();
//
//		Cart cart = new Cart();
//		
//		cart.setUser(user);
//		cart.setCartId(null);
//		cart.setCartitems();
//		cart.setCartTotPrice(0);
//
//		CartItem insertCart = cartItemServiceImpl.insert(cartItem);
//		System.out.println("insert>>>>>>>>>>>>>>>>>>" + insertCart);
//	}

}
