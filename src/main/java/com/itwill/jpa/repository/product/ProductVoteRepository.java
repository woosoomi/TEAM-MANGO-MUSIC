package com.itwill.jpa.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.jpa.entity.vote.Vote;

public interface ProductVoteRepository extends JpaRepository<Vote, Long>{

	@Query(value = "SELECT * FROM product p JOIN vote v ON p.vote_id = v.vote_id WHERE p.vote_id = :voteId", nativeQuery = true)
	String findProductVoteId(@Param("voteId") Long voteId);
}
