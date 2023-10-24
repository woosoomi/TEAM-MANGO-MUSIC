package com.itwill.jpa.service.board;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardCategory;

class BoardServiceImplTest extends TeamProjectMangoApplicationTest {

	@Autowired
	BoardServiceImpl boardServiceImpl;

	// 게시글저장 -성공
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void boardInsertTest() {
		Board board = new Board();
		board.setBoardCategory(new BoardCategory(2L, "이벤트", null));
		board.setBoardTitle("테스트중");
		board.setBoardContent("테스트내용");
		board.setBoardImage("테스트이미지");

		Board insertBoard = boardServiceImpl.insert(board);
		System.out.println(insertBoard);
	}

	// 게시물삭제 --성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void boardDeleteTest() {
		boardServiceImpl.delete(1L);
	}

	// 게시물수정 -성공
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void testUpdateBoardTest() {
		// 가상의 Board 객체 생성
		Board board = new Board();
		board.setBoardId(1L);
		board.setBoardTitle("새로운 제목");
		board.setBoardContent("새로운 내용");
		board.setBoardImage("새로운 이미지");

		Board updatedBoard = boardServiceImpl.update(board);
		System.out.println(updatedBoard);

	}

	// 카테고리별 구분 --성공
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void findByCategoryTest() {
		List<Board> boards = new ArrayList<Board>();
		boards = boardServiceImpl.findBycategory(4L); // 1대1문의 찾기
		System.out.println("1대1문의 게시글 모음 >>>>>" + boards);
	}
	
	//최근 한달 게시물 검색 --성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findByDateCategoryTest() {
		List<Board> boards = new ArrayList<Board>();
		LocalDateTime endDate = LocalDateTime.now(); // 현재 날짜와 시간
		LocalDateTime startDate = LocalDateTime.now().minusMonths(1); // 한 달 전의 날짜와 시간
		boards = boardServiceImpl.searchBoardsByDateRange(startDate, endDate);
		System.out.println("최근 한달의 게시글 모음 >>>>>"+boards);
	}

}
