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
import com.itwill.jpa.dao.cart.CartDaoImpl;
import com.itwill.jpa.dto.cart.CartDto;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
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
	void cartInsert() throws Exception {


		//User user1 =new User("lsg34", "1111", "test", "1111", "1111", "1111", "1111", "1111", null, null, null, null, null, null);
		//userRepository.save(user1);
		Optional<User> findUser = userRepository.findById("lsg33");

		System.out.println("findUser>>>>>>>>>>>>>>>"+findUser);
		if (findUser.isPresent()) {
			User user = findUser.get();
			CartDto cart1 = CartDto.builder().cartId(0L).cartTotPrice(1000).userId(user.getUserId()).build();
			System.out.println("cart1>>>>>>>>>>>>>>>>"+cart1);
			CartDto insertedCart=cartServiceImpl.insert(cart1);
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
	void cartDelete() throws Exception {
		Optional<Cart> findCart = cartRepository.findById(1L);
		System.out.println("findCart>>>>>>>>>>>>>>"+findCart);
	    if (findCart.isPresent()) {
	        Cart cart = findCart.get();
	        cartServiceImpl.deleteAllByCartId(cart.getCartId());
	    }
	}
	

	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void calTotPrice() throws Exception {
		Optional<Cart> findCart = cartRepository.findById(1L);
		 if (findCart.isPresent()) {
		        Cart cart = findCart.get();
		        List<CartItem> cartItems = cart.getCartitems();
		        CartDto totalPrice = cartServiceImpl.calculateTotalPrice(cartItems);
		        cart.setCartTotPrice(totalPrice.getCartTotPrice());
		        cartRepository.save(cart);
		        System.out.println("totalprice>>>>>>>>>>"+totalPrice);
		        System.out.println("cart>>>>>>>>>>>>"+cart);
		 }
	}

	/*
	@Test
	//@Disabled
	@Transactional
	@Rollback(false)
	void getCartItems() throws Exception {
		Cart findCart = cartRepository.findById(1L).orElse(null);
		CartDto toDto = CartDto.toDto(findCart); 
		List<CartDto> dtos = cartServiceImpl.getCartItems(toDto);
		System.out.println("find>>>>>>>>>>"+findCart);
		System.out.println("cartItems>>>>>>>>>>"+dtos);
	}
	*/
}