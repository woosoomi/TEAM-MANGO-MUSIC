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
					   .userid("asd")
					   .userpw("1111")
					   .username("한영")
					   .useraddress("s")
					   .useremail("s")
					   .userjumin("aaaa")
					   .userphone("1111111111")
					   .usergender("남")
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
