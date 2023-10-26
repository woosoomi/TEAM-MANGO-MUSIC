package com.itwill.jpa.repository.board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.board.Board;

public interface BoardRepository extends JpaRepository<Board,Long >{

	List<Board> findAll();
	
	//카테고리ID로 분류하기
	List<Board> findByBoardCategory_IdOrderByCreatedTime(Long boardcategoryid);
	
	//keyword가 포함된 title찾기 
    List<Board> findByBoardTitleContaining(String keyword);
    
    //기간으로 찾기 
    List<Board> findByCreatedTimeBetween(LocalDateTime startDate, LocalDateTime endDate);


}
