package com.itwill.jpa.entity.vote;

import java.sql.Date;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "vote")
@Table(name = "votes")
public class Vote {
	/*
	 
	 서비스 구현 순서
	 
	 1. 회원 아이디로 투표하기
	  	1-1. 회원 아이디 -> 투표하기 틀릭 시 투표수 증가 (1인 1투표 가능하게 설정)
	 
	 2. 투표율 정산
	 	2-1. 1차  가수 추출  --> 플레이 횟수 + 댓글 수 + 좋아요 수 합산(Top 20명 보여주기) 
	 	2-2. 최종 가수 추출  --> 합산 점수 + 투표수 ---> 점수높은 순 아티스트 순서 정렬(Top 10명 보여주기) 
	 
	 */
	
	// 엔티티 DTO만 설정
	
	
	@Id 
	@Column(name = "userId")
	private User user;
	private Product product;
	
	@Id 
	@Column(name = "musicReplay")
	// private int musicReplay;		//  음악 플레이 횟수
	// private int reply;			//  음악 댓글 수
	// private int likes;			//  음악 좋아요 수
	private int vote;				//  투표 수
	private Date date; 				//  투표 날짜
	private long tot; 				//  투표 합산점수

	/*
	public static Vote toEntity(VoteDto dto, User user) {
    	return Vote.builder()
    				.user(user.getUserId())
    				.user(user)
    				.build();


	}
	*/
}
