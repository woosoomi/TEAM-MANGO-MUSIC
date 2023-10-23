package com.itwill.jpa.dao.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.cart.Cart;
import com.itwill.jpa.entity.user.User;

class UserDaoImplTest extends TeamProjectMangoApplicationTest{
	@Autowired
	UserDao userDao;
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원가입")
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
	      
	      User user2 = User.builder()
                 .userId("zzz")
                 .userPw("2222")
                 .userName("zzz")
                 .userAddress("zzz")
                 .userEmail("zzz@naver.com")
                 .userJumin("000000-0000000")
                 .userPhone("011-1234-5678")
                 .userGender("여")
                 .build();
	      
			/*
			 * Cart cart = Cart.builder() .cartId(1L) .build();
			 */
	
	      System.out.println("===" + user1);
	      System.out.println("===" + user2);
	      //user1.setCart(cart);
	      //user2.setCart(cart);
	      
	      userDao.createUser(user1);
	      userDao.createUser(user2);
	      
	      
}
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원업데이트")
	   void testUpdate() throws Exception {
	      User user1 = userDao.findUser("zzz");
	      user1.setUserGender("남자ㅋㅋ");
	      userDao.updateUser(user1);
	
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원삭제")
	   void testDelete() throws Exception {
	      userDao.deleteUser("zzz");
	
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원삭제")
	   void testUserList() throws Exception {
		userDao.findUserList();
		
	
	}
}
