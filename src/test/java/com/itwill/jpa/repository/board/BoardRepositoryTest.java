package com.itwill.jpa.repository.board;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardCategory;

class BoardRepositoryTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	BoardCategoryRepository boardCategoryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void boardSaveTest() {
		
		BoardCategory boardCategory= BoardCategory.builder()
			.id(2L)
			.boardCategoryName("이벤트")
			.build();
		Board board = Board.builder()
						   .boardId(null)
						   .boardTitle("boardTest")
						   .boardContent("테스트중입니다")
						   .boardImage("uploads/image1")
						   .build();
		
		BoardCategory boardCategory1= BoardCategory.builder()
				.id(1L)
				.boardCategoryName("공지사항")
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
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findAll() {
	    List<Board> boards = boardRepository.findAll();
	    for (Board board : boards) {
	        System.err.println("Board Title 은 무엇?: " + board.getBoardTitle());
	    }
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByCategoryId() {
		List<Board> boards = boardRepository.findByBoardCategory_IdOrderByCreatedTime(1L);
		System.out.println(boards);
	}
	
}
