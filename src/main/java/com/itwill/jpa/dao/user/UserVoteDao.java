package com.itwill.jpa.dao.user;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.itwill.jpa.dto.user.UserUpdateDto;
import com.itwill.jpa.dto.user.UserVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;

public interface UserVoteDao {

	// 유저의 투표번호로 투표와 유저정보 조회
	String findUserVoteId(Long voteId);
	
	// 유저의 투표번호로 투표,상품전체조회
	User findUserVoteIdWithProduct(UserVoteDto userVoteDto);
	
	// findProductVoteId --> product의 voteId로 product와 Vote 전체 호출
	String  findProductVoteId(Long voteId);
	
	// findProductVoteIdWithUser --> product의 voteId로 User와 Vote 전체 호출
	Product findProductVoteIdWithUser(Long voteId);

	// 상품에서 음악 조회수(readCount), 음악 별점(productStar)의 합산해서 Top 20명 추출
	List<Product> findTop20ByTotalScore();

}
