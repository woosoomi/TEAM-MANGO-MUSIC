package com.itwill.jpa.dto.vote;

import java.sql.Date;

public class Vote {
	
	/*
	 
	 서비스 구현 순서
	 
	 1. 회원 아이디로 투표하기
	  	1-1. 회원 아이디 -> 투표하기 틀릭 시 투표수 증가 (1인 1투표 가능하게 설정)
	 
	 2. 투표율 정산
	 	2-1. 1차  가수 추출  --> 플레이 횟수 + 댓글 수 + 좋아요 수 합산(Top 20명 보여주기) 
	 	2-2. 최종 가수 추출  --> 합산 점수 + 투표수 ---> 점수높은 순 아티스트 순서 정렬(Top 10명 보여주기) 
	 
	 */
	
	// 용어 수정 예정--> 이름 임의로 작성하였으며 추후 통일 예정
	private String userId;	 		//  회원 아이디
	private String artist;			// 	가수
	
	private int musicReplay;		//  음악 플레이 횟수
	private int reply;				//  음악 댓글 수
	private int likes;				//  음악 좋아요 수
	private int vote;				//  투표 수
	private Date date; 				//  투표 날짜
	private long tot; 				//  투표 합산점수
	
}
