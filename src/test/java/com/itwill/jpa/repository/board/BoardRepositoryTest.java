package com.itwill.jpa.repository.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplication;
import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.Board.BoardCategory;

class BoardRepositoryTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void boardSaveTest() {
		
		BoardCategory boardCategory= BoardCategory.builder()
			.boardCategoryId(null)
			.boardCategoryName("이벤트")
			.build();
		Board board = Board.builder()
						   .boardId(null)
						   .boardTitle("boardTest")
						   .boardContent("테스트중입니다")
						   .boardImage("uploads/image1")
						   .build();
		
		BoardCategory boardCategory1= BoardCategory.builder()
				.boardCategoryId(null)
				.boardCategoryName("매거진")
				.build();
		Board board1 = Board.builder()
							.boardId(null)
							.boardTitle("boardTest2")
							.boardContent("테스트중입니다2")
							.boardImage("uploads/image1")
							.build();
		
		board.setBoardCategory(boardCategory);
		boardRepository.save(board);
		
		board1.setBoardCategory(boardCategory1);
		boardRepository.save(board1);
	   
	}
	
}
