package com.itwill.jpa.entity.Board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.board.BoardDto;
import com.itwill.jpa.entity.user.User_Board;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "board")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @SequenceGenerator(name = "BOARD_BOARD_NO_SEQ",sequenceName = "BOARD_BOARD_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_BOARD_NO_SEQ")
	private Long boardId;
	
    private String boardTitle;
    private String boardContent;
    private String boardImage;

    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    
    public static Board toEntity(BoardDto dto) {
    	return Board.builder()
    				.boardTitle(dto.getBoardTitle())
    				.boardContent(dto.getBoardContent())
    				.boardImage(dto.getBoardImage())
    				.createdTime(dto.getCreatedTime())
    				.updateTime(dto.getUpdateTime())
    				.build();
    }
    //board - boardcategory 1대1
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "boardcategory_no")
	private BoardCategory boardCategory;
	
	//board- userboard 1대n
	@OneToMany(mappedBy = "board",  cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<User_Board> userBoard = new ArrayList<User_Board>();
	
	
	
}


