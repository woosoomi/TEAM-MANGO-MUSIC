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
    @SequenceGenerator(name = "BOARD_CATEGORY_NO_SEQ",sequenceName = "BOARD_CATEGORY_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_CATEGORY_NO_SEQ")
	private Long boardCategoryId;
	
	private String boardCategoryName;
	
	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder()
							.boardCategoryName(dto.getBoardCategoryName())
							.build();
	}
	
	
}
