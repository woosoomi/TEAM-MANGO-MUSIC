package com.itwill.jpa.service.cart;



import java.util.ArrayList;
import java.util.Collections;
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
	//@Disabled
	@Rollback(false)
	
	void cartInsert() {
		//User user1 =new User("test102", "1111", "test", "1111", "1111", "1111", "1111", "1111", null, null, null, null, null, null);
		//userRepository.save(user1);
		Optional<User> findUser = userRepository.findById("lsg33");
		System.out.println("findUser>>>>>>>>>>>>>>>"+findUser);
		if (findUser.isPresent()) {
			User user = findUser.get();
			Cart cart1 = Cart.builder().cartId(0L).cartTotPrice(1000).user(user).build();
			System.out.println("cart1>>>>>>>>>>>>>>>>"+cart1);
			Cart insertedCart=cartServiceImpl.insert(cart1);
			System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+insertedCart);
		}
		//cart1.setUser();
		//cart1.getCartitems();
		//cart1.setCartId(0L);
		//cart1.setCartTotPrice(1000);
		
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
	

	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void calTotPrice() {
		Optional<Cart> findCartItem = cartRepository.findById(642L);
		System.out.println();
		if(findCartItem.isPresent()) {
			Cart cart = findCartItem.get();
			System.out.println("cart>>>>>>>>>>>>>>>>"+cart);
			double totalPrice = cartServiceImpl.calculateTotalPrice(Collections.singletonList(cart));
			System.out.println("tot price>>>>>>>"+totalPrice);
		}else {
			System.out.println("error");
		}
		
	}
	

}
