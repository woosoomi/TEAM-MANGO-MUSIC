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
	
/*
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	VoteServiceImpl voteServiceImpl;
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void creatVoteTest() throws Exception {
		
		Date localDate = new Date(2023);

			
		 Vote vote = Vote.builder()
				 		  .voteTot(250)
				 		  .voteDate(localDate)
				 		  .build();

		em.persist(vote);
		
		Vote insertVote = voteServiceImpl.createVote(vote);
		em.persist(insertVote);
		System.out.println("~~~~~~~~~~~~~~~"+insertVote);
		
	}
	
*/
}
