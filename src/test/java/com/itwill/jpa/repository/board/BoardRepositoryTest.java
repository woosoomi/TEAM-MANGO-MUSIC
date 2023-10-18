package com.itwill.jpa.repository.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplication;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.user.UserRepository;

class BoardRepositoryTest extends TeamProjectMangoApplication{

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	UserRepository userRepository;
	@Test
	@Disabled
	@Transactional
	@Rollback(false)
	void saveBoardWithUser() {
		User user= User.builder()
					   .userId("asd")
					   .userPw("1111")
					   .userName("한영")
					   .userAddress("s")
					   .userEmail("s")
					   .userJumin("aaaa")
					   .userPhone("1111111111")
					   .userGender("남")
					   .build();
		
		Board board=Board.builder()
						 .boardCategory("event")
						 .boardTitle("테스트")
						 .boardContent("테스트중입니다")
						 .boardImage(null)
						 .createdTime(null)
						 .updateTime(null)
						 .build();
		
//		board.getUser().add(user);
//		user.setBoards(board);
		
		boardRepository.save(board);
	}
}
