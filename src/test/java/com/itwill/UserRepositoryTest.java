package com.itwill;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.User;
import com.itwill.jpa.repositiry.UserRepository;

class UserRepositoryTest {
	
	
	@Autowired 
	UserRepository userRepository;
	
	@DisplayName("회원가입")
	@Test

	void testSave() {
		User user1=User.builder()
					.userId("guard21")
					.password("2121")
					.name("김경호21")
					.email("guard21@gmail.com")
					.build();
		User savedUser1 = userRepository.save(user1);
		System.out.println(savedUser1);
		
	}
	
}
