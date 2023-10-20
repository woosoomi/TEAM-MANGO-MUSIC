package com.itwill.jpa.dto.vote;

import java.sql.Date;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class VoteDto {

	private Long voteNo;				//  투표 번호

	private Date voteDate; 				//  투표 날짜
	private int voteTot; 				//  투표 합산점수

	
}