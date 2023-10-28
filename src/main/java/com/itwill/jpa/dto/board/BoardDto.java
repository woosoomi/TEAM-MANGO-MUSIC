package com.itwill.jpa.dto.board;

import java.time.LocalDateTime;

import com.itwill.jpa.entity.board.Board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardDto {
    
	private Long boardId;
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private String boardImage;
    private String boardPrize;
    private int boardReadCount;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;

    public static Board toDto(Board entity) {
    	return Board.builder()
    				.boardId(entity.getBoardId())
    				.boardTitle(entity.getBoardTitle())
    				.boardContent(entity.getBoardContent())
    				.boardImage(entity.getBoardImage())
    				.boardPrize(entity.getBoardPrize())
    				.boardReadCount(entity.getBoardReadCount())
    				.createdTime(entity.getCreatedTime())
    				.updateTime(entity.getUpdateTime())
    				.build();
    }
    
	
}
