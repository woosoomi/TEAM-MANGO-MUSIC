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
	
	
		User user = new User();
		user.setUserId("테스트용아이디"); // 

		User user1=User.builder()
					  .userId(user.getUserId())
					  .userAddress("2")
					  .user_Boards(null)
					  .userEmail("2")
					  .userGender("2")
					  .userJumin("2")
					  .userName("2")
					  .userPhone("2")
					  .userPw("2")
					  .build();
		
		System.out.println(user1);
		
		cart1.setUser(user1);
		cart1.getCartitems().add(cartItems);
		user1.setCart(cart1);
		cartItems.setCart(cart1);
		
		
		cartItemRepository.save(cartItems);
		userRepository.save(user1);
		cartRepository.save(cart1);

	}
	

}
