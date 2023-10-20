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
	@SequenceGenerator(name = "vote_no_seq",sequenceName = "vote_no_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vote_no_seq")
	private Long voteNo;				

	
	// 유저_회원
	@JoinColumn
	private User user;				
	
	@JoinColumn
	private Product product;
	/* 
	★ 음악_상품에서 가져와야하는 것 ★
	private int musicReplay;		// 	음악 조회수
	private int reply;				//  음악 댓글
	private int likes;				//  음악 별점
	
	*/
	
	// 투표 날짜
	@CreationTimestamp
	private Date voteDate; 				
	
	// 투표 합산점수
	private long tot; 			
	
	public static Vote toEntity(VoteDto voteDto, User user, Product product) {
		return Vote.builder()
				   .voteNo(voteDto.getVoteNo())
				   .user(user)
				   .product(product)
				   .build();
		
	}
	
}