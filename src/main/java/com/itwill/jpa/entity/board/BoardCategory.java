package com.itwill.jpa.entity.board;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.board.BoardCategoryDto;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@SequenceGenerator(name = "BOARD_BOARD_NO_SEQ", sequenceName = "BOARD_BOARD_NO_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_BOARD_NO_SEQ")
	private Long id;

	private String boardCategoryName;

	public static BoardCategory toEntity(BoardCategoryDto dto) {
		return BoardCategory.builder().boardCategoryName(dto.getBoardCategoryName()).build();
	}
	//1대N관계설정
	@OneToMany(mappedBy = "boardCategory", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Board> boards = new ArrayList<Board>();

}