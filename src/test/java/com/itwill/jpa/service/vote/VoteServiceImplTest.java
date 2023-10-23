package com.itwill.jpa.service.vote;



import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;

import com.itwill.jpa.TeamProjectMangoApplicationTest;


import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.vote.VoteRepository;

import jakarta.persistence.EntityManager;

@SpringBootTest
@Transactional
class VoteServiceImplTest extends TeamProjectMangoApplicationTest{

	@Autowired
	VoteServiceImpl voteServiceImpl;
	
	@Autowired
	VoteService voteService;
	@Autowired
	VoteRepository voteRepository;
	
	
	@Test
	void creatVoteTest() throws Exception {
		
		User user1 = new User();
		Product product1= new Product();
		 				       product1.setProductName("아름다운사실");
		 				       product1.setProductContent("명곡입니다.");
		 				       product1.setProductReply("아름다워요");
		 				       product1.setProductStar("5");
		 				       product1.setProductArtist("부활");
		 				       
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~"+product1);
		Date localDate = new Date(2023);
		Vote vote = new Vote();
		vote.setVoteNo(1L);
		vote.setProduct(product1);
		vote.setUser(user1);
		vote.setVoteDate(localDate);
		vote.setVoteTot(20);
		
		
		Vote insertVote = voteServiceImpl.createVote(vote);
		System.out.println("~~~~~~~~~~~~~~~"+insertVote);
	}
	
	

}
