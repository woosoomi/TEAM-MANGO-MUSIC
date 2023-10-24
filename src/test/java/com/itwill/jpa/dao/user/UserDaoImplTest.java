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
	
	      System.out.println("===" + user1);
	      System.out.println("===" + user2);
	    
	      userDao.createUser(user1);
	      userDao.createUser(user2);
	      
}
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원한명찾기")
	   void testfindUser() throws Exception {
	      User user1 = userDao.findUser("범석님");
	      System.out.println(user1);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원로그인")
	void testlogin() throws Exception {
		String UserId = "범석님";
        String UserPw = "8888";

        User loginUser = userDao.loginUser(UserId, UserPw);

        assertNotNull(loginUser);
        assertEquals(UserId, loginUser.getUserId());

        System.out.println("로그인 성공: " + loginUser);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원업데이트")
	   void testUpdate() throws Exception {
	      User user1 = userDao.findUser("범석님");
	      user1.setUserAddress("충남 서천군ㅋㅋ");
	      userDao.updateUser(user1);
	      
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원삭제")
	   void testDelete() throws Exception {
	      userDao.deleteUser("aaa");
	
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원전체리스트")
	   void testUserList() throws Exception {
		System.out.println(">>> 회원전체리스트: " + userDao.findUserList());
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("회원중복테스트")
	   void testexistsById() throws Exception {
		Boolean existById = userDao.existsById("회원님");
		System.out.println(">>> : " + existById);
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("아이디찾기1")
	   void testfindUserIdByUserEmail() throws Exception {
		String userEmail = "kbs@gmail.com";
		String findUserId1 = userDao.findUserIdByUserEmail(userEmail);
		
		System.out.println(">>> testfindUserIdByUserEmail: " + findUserId1);
		
	}
	
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	@DisplayName("아이디찾기2")
	   void testfindUserIdByUserPhone() throws Exception {
		String userPhone = "010-1111-1111";
		String findUserId2 = userDao.findUserPwByUserPhone(userPhone);
		
		System.out.println(">>> testfindUserIdByUserPhone: " + findUserId2);
		
	}
}
