package com.itwill.jpa.service.cart;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class CartServiceImplTest extends TeamProjectMangoApplicationTest {
	@Autowired
	CartServiceImpl cartServiceImpl;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Test
	@Transactional
	@Disabled
	@Rollback(false)
	void cartInsert() {
		User user1 =new User("test102", "1111", "test", "1111", "1111", "1111", "1111", "1111", null, null, null, null, null, null);
		userRepository.save(user1);
		
		Cart cart1 = new Cart();
		cart1.setUser(user1);
		cart1.getCartitems();
		cart1.setCartId(0L);
		cart1.setCartTotPrice(1000);
		Cart insertedCart=cartServiceImpl.insert(cart1);
		
		System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+insertedCart);
		
		/*
		Cart cart2 = new Cart();
		CartItem cartItem2 =new CartItem(0L,10000,null,null);
		User user2 =new User("test11", "1111", "test", "1111", "1111", "1111", "1111", "1111", null, null, null, null, null);
		
		
		cart2.setUser(user2);
		cart2.getCartitems();
		cart2.setCartId(1L);
		cart2.setCartTotPrice(78000);
		
		cartRepository.save(cart2);
		cartItemRepository.save(cartItem2);
		userRepository.save(user2);
		Cart insertedCart1=cartServiceImpl.insert(cart2);
		System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+insertedCart1);
		*/
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void cartDelete() {
		cartServiceImpl.deleteAllByCartId(306L);;
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void getCartItems() {
		Optional<Cart> findCart = cartRepository.findById(138L);
		List<Cart> cartItems = cartServiceImpl.getCartItems(findCart.get());
		System.out.println("find>>>>>>>>>>"+findCart);
		System.out.println("cartItems>>>>>>>>>>"+cartItems);
	}
	
	/*
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void calTotPrice() {
		Optional<Cart> findCart = cartRepository.findById(138L);
		List<Cart> cartItems = cartServiceImpl.getCartItems(findCart.get());
		cartServiceImpl.calculateTotalPrice(cartItems);
		System.out.println("caltot>>>>>>>>>>>>"+cartItems);
	}
	*/

}
