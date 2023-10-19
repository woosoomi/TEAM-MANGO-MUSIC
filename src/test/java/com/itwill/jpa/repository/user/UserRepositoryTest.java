package com.itwill.jpa.repository.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.user.User;

class UserRepositoryTest extends TeamProjectMangoApplicationTest {
	UserRepository userRepository;

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

		Board board1 = Board.builder()
							.boardCategory("event1")
							.boardTitle("테스트1")
							.boardContent("테스트중입니다1")
							.boardImage(null)
							.createdTime(null)
							.updateTime(null)
							.build();

		user1.getBoards().add(board1);
		board1.setUser(user1);

		userRepository.save(user1);

	}
}
