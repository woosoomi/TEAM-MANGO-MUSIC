package com.itwill.jpa.dto.vote;

import java.sql.Date;

import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class VoteDto {

	private int voteNo;				//  투표 번호

<<<<<<< HEAD
	private Date voteDate; 				//  투표 날짜
	private int voteTot; 				//  투표 합산점수
=======
	private Date voteDate; 			//  투표 날짜
	private long tot; 				//  투표 합산점수
>>>>>>> branch 'master' of https://github.com/2023-05-JAVA-DEVELOPER-143/2023-05-JAVA-DEVELOPER-final-project-team1-mango.git
	
	// private User user;	 		//  유저_회원 --> 조인연산
	// private Product product;		// 	음악_상품 --> 조인연산
	
}
