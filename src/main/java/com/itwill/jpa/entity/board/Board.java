package com.itwill.jpa.entity.board;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.board.BoardDto;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.user.UserBoard;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Entity
@Table(name = "board")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    //board - boardcategory  n대1
	@ManyToOne
	@JoinColumn(name = "board_category_id")
	@ToString.Exclude
	private BoardCategory boardCategory;
		
	//board- userboard 1대n
	@OneToMany(mappedBy = "board",  cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<UserBoard> userBoard = new ArrayList<UserBoard>();
    
	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<BoardReply> boardReply = new ArrayList<>();
	
	
}

