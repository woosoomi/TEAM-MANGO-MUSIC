package com.itwill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repositiry.UserRepository;

class UserRepositoryTest {
	
	
	@Autowired 
	UserRepository userRepository;
	
	@DisplayName("회원가입")
	@Test

	void testSave() {

		User user1=User.builder()
					.user_id("guard21")
					.user_pw("2121")
					.user_name("김경호21")
					.user_phone("010-1234-5678")
					.user_address("guard21@gmail.com")
					.user_email("guard21@gmail.com")
					.user_jumin("20231017-2***")
					.user_gender("여성")
					.build();
		//User savedUser1 = userRepository.save(user1);
		//System.out.println(savedUser1);

		
	}
	
}
