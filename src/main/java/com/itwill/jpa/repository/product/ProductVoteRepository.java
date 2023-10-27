package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.vote.Vote;

public interface ProductVoteRepository extends JpaRepository<Vote, Long>{

	// findProductVoteId --> product의 voteId로 product와 Vote 전체 호출
	@Query(value = "SELECT * FROM product p JOIN vote v ON p.vote_id = v.vote_id WHERE p.vote_id = :voteId", nativeQuery = true)
	String findProductVoteId(@Param("voteId") Long voteId);
	
	
	// findProductVoteIdWithUser --> product의 voteId로 User와 Vote 전체 호출
	@Query(value = "SELECT u.*, p.*, v.* FROM UserInfo u INNER JOIN Product p ON u.vote_id = p.vote_id INNER JOIN Vote v ON p.vote_id = v.vote_id WHERE p.vote_id = :voteId", nativeQuery = true)
	String findProductVoteIdWithUser(@Param("voteId") Long voteId);


	// 상품에서 음악 조회수(readCount), 음악 별점(productStar)의 합산해서 Top 20명 추출
	@Query(value = "SELECT * FROM (SELECT p.*, (NVL(p.read_Count, 0) + NVL(p.product_Star, 0)) AS total_score FROM Product p ORDER BY total_score DESC) WHERE ROWNUM <= 20")
    List<Product> findTop20ByTotalScore();
}
