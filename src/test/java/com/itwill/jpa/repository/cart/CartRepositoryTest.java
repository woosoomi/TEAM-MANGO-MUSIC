package com.itwill.jpa.repository.cart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class CartRepositoryTest extends TeamProjectMangoApplicationTest {

	@Autowired
	CartRepository cartRepository;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	UserRepository userRepository;
	@Test
	//@Disabled
	@Transactional
	void saveCartWithCartItems() {
		Cart cart1 = Cart.builder()
							.cartTotPrice(0)
							.build();
	
		CartItem cartItems = CartItem.builder()
										.cartItemQty(0)
										.build();
	
	
	/*
		User user=User.builder()
					  .userId("88")
					  .userAddress("2")
					  .user_Boards(null)
					  .userEmail("2")
					  .userGender("2")
					  .userJumin("2")
					  .userName("2")
					  .userPhone("2")
					  .userPw("2")
					  .build();
	*/

		cart1.getCartitems().add(cartItems);
		//cart1.setUser(user);
		cartItems.setCart(cart1);
		cartItemRepository.save(cartItems);
		//userRepository.save(user);
		cartRepository.save(cart1);

	}
	

}
