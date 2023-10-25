package com.itwill.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itwill.jpa.entity.vote.Vote;

public interface UserVoteRepository extends JpaRepository<Vote, Long>{

	@Query(value = "SELECT * FROM userinfo u JOIN vote v ON u.vote_id = v.vote_id WHERE u.vote_id = :voteId", nativeQuery = true)
	String findUserVoteId(@Param("voteId") Long voteId);
}
