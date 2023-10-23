package com.itwill.jpa.service.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartItemRepository;
import com.itwill.jpa.repository.cart.CartRepository;
import com.itwill.jpa.repository.user.UserRepository;

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
	void cartInsert() {
		Cart cart = new Cart();
		CartItem cartItem =new CartItem(3L,1000,null,null);
		User user =new User("123","1111","한영","010-1111","안양","why","960410","남", null, null, null, null);
		
		
		cart.setUser(user);
		cart.getCartitems();
		cart.setCartId(10L);
		cart.setCartTotPrice(1000);
		
		cartRepository.save(cart);
		userRepository.save(user);
		
		List<CartItem> cartItems = new ArrayList<>();
		
		CartItem cartItem1 = new CartItem();
		cartItem1.setCartItemId(11L);
		cartItem1.setCartItemQty(200);
	
		CartItem cartItem2 = new CartItem();
		cartItem2.setCartItemId(12L);
		cartItem2.setCartItemQty(500);
		
		cartItems.add(cartItem1);
		cartItems.add(cartItem2);
		
		cartItemRepository.save(cartItem1);
		cartItemRepository.save(cartItem2);
		
		Cart inserCart=cartServiceImpl.insert(cartItems);
		System.out.println("insert>>>>>>>>>>>>>>>>>>>>>"+inserCart);
	}

}
