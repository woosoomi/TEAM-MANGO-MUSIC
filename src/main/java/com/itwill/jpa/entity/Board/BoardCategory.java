package com.itwill.jpa.entity.Board;


import com.itwill.jpa.dto.board.BoardCategoryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategory {
	@Id
	private Long boardCategoryId;
	
	private String boardCategoryName;
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.boardCategoryName(dto.getBoardCategoryName())
							.build();
	}
}
