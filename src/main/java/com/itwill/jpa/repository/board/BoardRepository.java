package com.itwill.jpa.repository.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Board.Board;

public interface BoardRepository extends JpaRepository<Board,Long >{

	List<Board> findAll();

	List<Board> findByBoardCategory_IdOrderByCreatedTime(Long categoryId);

}
