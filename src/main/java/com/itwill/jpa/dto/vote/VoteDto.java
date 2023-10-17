package com.itwill.jpa.dto.vote;

import java.sql.Date;


public class VoteDto {
	
	
	// 용어 수정 예정 임의로 작성
	private String userId;	 		//  회원 아이디
	private String artist;			// 	가수
	
	private int musicReplay;		//  음악 플레이 횟수
	private int reply;				//  음악 댓글 수
	private int likes;				//  음악 좋아요 수
	private int vote;				//  투표 수
	private Date date; 				//  투표 날짜
	private long tot; 				//  투표 합산점수
	
}
