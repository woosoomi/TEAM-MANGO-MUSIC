package com.itwill.jpa.entity.Board;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.thymeleaf.templateparser.text.AbstractChainedTextHandler;

import com.itwill.jpa.dto.board.boardDto;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long boardNo;

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
}


