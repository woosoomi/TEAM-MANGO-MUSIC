package com.itwill.jpa.service.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardCategory;
import com.itwill.jpa.repository.board.BoardCategoryRepository;
import com.itwill.jpa.repository.board.BoardRepository;

class BoardServiceImplTest extends TeamProjectMangoApplicationTest{

	@Autowired
	BoardServiceImpl boardServiceImpl;
	
	//게시글저장
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void boardInsertTest() {
		Board board = new Board();
		board.setBoardCategory(new BoardCategory(2L,"이벤트", null));
		board.setBoardTitle("테스트중");
		board.setBoardContent("테스트내용");
		board.setBoardImage("테스트이미지");
		
		Board insertBoard = boardServiceImpl.insert(board);
		System.out.println(insertBoard);
	}
	

}
