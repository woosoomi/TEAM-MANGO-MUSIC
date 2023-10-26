package com.itwill.jpa.service.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class CartItemServiceImplTest extends TeamProjectMangoApplicationTest {

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	UserRepository userRepository;

	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void cartItemInsert() {
		/*
		User user = new User("test1", "1111", "1111", "1111", "1111", "1111", "1111", null, null, null, null, null, null);
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setCartId(138L);
		List<CartItem> cartItems = new ArrayList<>();
		CartItem cartItem1 = CartItem.builder().cartItemId(0L).cartItemQty(10).cart(cart).build();
		CartItem cartItem2 = CartItem.builder().cartItemId(0L).cartItemQty(15).cart(cart).build();
		CartItem cartItem3 = CartItem.builder().cartItemId(0L).cartItemQty(16).cart(cart).build();

		cartItems.add(cartItem1);
		cartItems.add(cartItem2);
		cartItems.add(cartItem3);
		
		cart.setCartitems(cartItems);
		try {
		List<CartItem> insertedCartItems = cartItemServiceImpl.insertAll(cartItems);
			System.out.println("insert>>>>>>>>>>>>>>>>>>" + insertedCartItems);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		cartRepository.save(cart);
		userRepository.save(user);
		*/
	}
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void deleteByCartItemId() {
		cartItemServiceImpl.deleteByCartItemId(401L);
	}
	
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void updateCartItemsQty() throws Exception {
		Long cartItemId = 330L;
		int updateQty = 5;
		cartItemServiceImpl.update(cartItemId, updateQty);
		
	}

}
