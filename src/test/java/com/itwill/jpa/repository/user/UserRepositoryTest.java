package com.itwill.jpa.repository.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.board.BoardRepository;

class UserRepositoryTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;

	   @Test
	   //@Disabled
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

			/*
			 * Board board1 = Board.builder() .boardCategory("event1") .boardTitle("테스트1")
			 * .boardContent("테스트중입니다1") .boardImage(null) .createdTime(null)
			 * .updateTime(null) .build();
			 */
	      
	      System.out.println(">>> " + user1);
	      userRepository.save(user1);
	      

	   }

}
