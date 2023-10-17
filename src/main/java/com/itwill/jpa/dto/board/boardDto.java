package com.itwill.jpa.dto.board;

import java.time.LocalDateTime;


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
public class boardDto {
    
	private String boardCategory;
	private String boardTitle;
	private String boardContent;
	private String boardImage;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;

    
	
}
