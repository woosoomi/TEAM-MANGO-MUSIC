package com.itwill.jpa.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Board.Board;

public interface BoardRepository extends JpaRepository<Board,Long >{

}
