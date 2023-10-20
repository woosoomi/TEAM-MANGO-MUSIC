package com.itwill.jpa.dao.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.repository.board.BoardRepository;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public Board insertBoard(Board board) {
		Board saveBoard = boardRepository.save(board);
		return saveBoard;
	}
	
	@Override
	public Board selectBoard(Long no) {
		Board selectBoard = boardRepository.findById(no).get();
		return selectBoard;
	}

	@Override
	public Board updateBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBoard(Long no) throws Exception {
		
	}

	@Override
	public List<Board> selectList() {
		return boardRepository.findAll();
	}
	
	
	
}
