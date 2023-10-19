package com.itwill.jpa.repository.user;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplication;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.board.BoardRepository;

public class UserRepositoryTest extends TeamProjectMangoApplication{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@DisplayName("회원가입")
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void testSave() {
		User user1 = User.builder()
						 .userId("kbs")
						 .userPw("1111")
						 .userName("고범석")
						 .userAddress("충남 서천군")
						 .userEmail("kbs@naver.com")
						 .userJumin("970000-0000000")
						 .userPhone("010-1234-5678")
						 .userGender("상남자")
						 .build();
		
		Board board1=Board.builder()
				 		  .boardCategory("event")
				 		  .boardTitle("테스트")
				 		  .boardContent("테스트중입니다")
				 		  .boardImage(null)
				 		  .createdTime(null)
				 		  .updateTime(null)
				 		  .build();
		
		user1.getBoards().add(board1);
		board1.setUser(user1);
	
		userRepository.save(user1);
	}
	
	
	
	
	
	
	
	
	
}
