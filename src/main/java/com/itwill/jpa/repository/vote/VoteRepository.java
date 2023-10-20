package com.itwill.jpa.repository.vote;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.vote.Vote;



public interface VoteRepository extends JpaRepository<Vote, String>{
	
	
}
