package com.itwill.jpa.dto.vote;

import java.sql.Date;

public class Vote {
	
	
	
	// 용어 수정 예정--> 이름 임의로 작성하였으며 추후 통일 예정
	private String userId;	 // 회원 아이디
	
	private int musicReplay; //  음악 플레이 횟수
	private int replyCount;	 //  음악 댓글 수
	private int likes;		 //  음악 좋아요 수
	private int vote;		 //  투표 수
	private Date date; 		 //  투표 날짜
	
}
