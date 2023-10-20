package com.itwill.jpa.repository.board;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Board.BoardCategory;

public interface BoardCategoryRepository extends JpaRepository<BoardCategory,Long>{

}
