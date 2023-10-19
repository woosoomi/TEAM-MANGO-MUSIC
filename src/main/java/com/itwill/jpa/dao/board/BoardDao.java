package com.itwill.jpa.dao.board;

import java.util.List;

import com.itwill.jpa.entity.Board.Board;

public interface BoardDao {
	
	Board createBoard(Board board);
	
	Board updateBoard(Board board);
	
	Board findBoard(Long boardNo);
	
	List<Board> findBoardList();
	
	
}
