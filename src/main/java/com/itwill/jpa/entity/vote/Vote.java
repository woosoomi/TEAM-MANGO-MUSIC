package com.itwill.jpa.entity.vote;

import java.sql.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
public class Vote {
//  투표번호
	@Id 
	@SequenceGenerator(name = "VOTE_NO_SEQ",sequenceName = "VOTE_NO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "VOTE_NO_SEQ")
	private Long voteNo;				

	
	// 유저_회원
	
	/* 음악_상품에서 가져와야하는 것
	private int musicReplay;		//  음악 플레이 횟수
	private int reply;				//  음악 댓글 수
	private int likes;				//  음악 좋아요 수
	*/
	
	// 투표 날짜
	@CreationTimestamp
	private Date voteDate; 				
	
	// 투표 합산점수
	private int voteTot; 			
	
	public static Vote toEntity(VoteDto dto) {
		return Vote.builder()
				   .voteDate(dto.getVoteDate())
				   .voteTot(dto.getVoteTot())
				   .build();
		
	}
	
}