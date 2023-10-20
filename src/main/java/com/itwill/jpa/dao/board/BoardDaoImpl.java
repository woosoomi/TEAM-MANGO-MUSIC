package com.itwill.jpa.dao.board;

import java.util.List;
import java.util.Optional;

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
	public Board updateBoard(Board updateboard) throws Exception {
		Optional<Board> findBoardOptional=
				boardRepository.findById(updateboard.getBoardId());
		Board updateBoard=null;
		if(findBoardOptional.isPresent()) {
			Board board=findBoardOptional.get();
			board.setBoardTitle(updateboard.getBoardTitle());
			updateboard=boardRepository.save(board);
		}else {
			throw new Exception("존재하지않는제품입니다");
		}
		return updateBoard;
	}

	@Override
	public void deleteBoard(Long no) throws Exception {
		Optional<Board> selectBoardOptional = boardRepository.findById(no);
		if(selectBoardOptional.isEmpty()) {
			throw new Exception();
		}
		boardRepository.delete(selectBoardOptional.get());
	}

	@Override
	public List<Board> selectList() {
		return boardRepository.findAll();
	}
	
	
	
}
