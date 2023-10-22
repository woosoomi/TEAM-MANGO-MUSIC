package com.itwill.jpa.entity.Board;



import com.itwill.jpa.dto.board.BoardCategoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "board_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Long id;
	
	private String boardCategoryName;
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.boardCategoryName(dto.getBoardCategoryName())
							.build();
	}
	
	
}
