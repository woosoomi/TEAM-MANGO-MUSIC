package com.itwill.jpa.entity.Board;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.board.boardDto;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
	private String boardId;
	
    private String boardCategory;
    private String boardTitle;
    private String boardContent;
    private String boardImage;

    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
    
    public static Board toEntity(boardDto dto) {
    	return Board.builder()
    				.boardCategory(dto.getBoardCategory())
    				.boardTitle(dto.getBoardTitle())
    				.boardContent(dto.getBoardContent())
    				.boardImage(dto.getBoardImage())
    				.createdTime(dto.getCreatedTime())
    				.updateTime(dto.getUpdateTime())
    				.build();
    }
    //user와 board N대1관계설정.
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	@Builder.Default
	private User user =new User();
	
	
}


