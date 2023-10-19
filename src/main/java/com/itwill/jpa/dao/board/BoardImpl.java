package com.itwill.jpa.dao.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.repository.board.BoardRepository;

@Repository
public class BoardImpl implements BoardDao{
	
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Board createBoard(Board board) {
		Board createBoard = boardRepository.save(board);
		return createBoard;
	}

	@Override
	public Board updateBoard(Board board) {
		Board updateBoard = boardRepository.save(board);
		return updateBoard;
	}

	@Override
	public Board findBoard(Long boardNo) {
		Board findBoard = boardRepository.findById(boardNo).get();
		return findBoard;
	}

	@Override
	public List<Board> findBoardList() {
		return boardRepository.findAll();
	}
}
