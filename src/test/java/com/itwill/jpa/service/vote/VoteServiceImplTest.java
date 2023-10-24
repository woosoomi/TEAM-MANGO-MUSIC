package com.itwill.jpa.service.vote;



import java.sql.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;

import com.itwill.jpa.TeamProjectMangoApplicationTest;


import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.repository.vote.VoteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
@Transactional
class VoteServiceImplTest extends TeamProjectMangoApplicationTest{
	

	@PersistenceContext
	EntityManager em;
	
	
	@Autowired
	VoteRepository voteRepository;

	@Autowired
	VoteServiceImpl voteServiceImpl;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void creatVoteTest() throws Exception {
		
		Date localDate = new Date(2023);
		Vote vote1 = Vote.builder()
		 		 		 .voteTot(320)
		 		 		 .build();
		  vote1.setVoteDate(localDate);
		  voteServiceImpl.createVote(vote1);
		  System.out.println("~~~~~~~~~~~~~~~"+voteServiceImpl.createVote(vote1));
		   
	}

		
	

}
