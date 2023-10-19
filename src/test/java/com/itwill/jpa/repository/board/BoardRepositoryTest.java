package com.itwill.jpa.repository.board;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
	//@Disabled
	@Transactional
	@Rollback(false)
	void saveBoardWithUser() {
		Board board=Board.builder()
				.boardId("board테스트")
				.boardCategory("event")
				.boardTitle("테스트")
				.boardContent("테스트중입니다")
				.boardImage(null)
				.createdTime(null)
				.updateTime(null)
				.build();
		
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
		
		board.setUser(user);
		System.out.println(board);
		boardRepository.save(board);
	}
	
//	@Transactional
//	@Rollback(false)
//	@Test
//	@Disabled
//	void selectUserWithBoard() {
//		Board board = boardRepository.findById(1L).get();
//		System.out.println("1. >>>>"+board);
//	}
}
