package com.itwill.jpa.repository.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.cart.CartRepository;

class UserRepositoryTest extends TeamProjectMangoApplicationTest {
	@Autowired
	UserRepository userRepository;

	@Autowired
	CartRepository cartRepository;

	@Test
	// @Disabled
	@Transactional
	@Rollback(false)
	void testSave() {
		User user1 = User.builder()
						.userId("kbs")
						.userPw("1111")
						.userName("고범석")
						.userAddress("서울시 강남")
						.userEmail("kbs@naver.com")
						.userJumin("970000-0000000")
						.userPhone("010-1234-5678")
						.userGender("남")
						.build();

		Cart cart = Cart.builder()
						.cartId(1L)
						.build();

		user1.setCart(cart);

		cartRepository.save(cart);
		userRepository.save(user1);
	}
}
