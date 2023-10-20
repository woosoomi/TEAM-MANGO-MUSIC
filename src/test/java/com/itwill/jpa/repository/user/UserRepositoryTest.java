package com.itwill.jpa.repository.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import com.itwill.jpa.entity.user.User;

class UserRepositoryTest extends SpringApplication{
	
	@Autowired
	UserRepository userRepository;

	@DisplayName("회원가입")
	@Test
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
	      
	      System.out.println(">>> " + user1);
	      userRepository.save(user1);
	      

	   }

}
