package com.itwill.jpa.service.vote;



import java.sql.Date;

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
	void creatVoteTest() throws Exception {
		
		Date localDate = new Date(2023);
		 
		User user1 = new User();
			 user1 = User.builder()
                 .userId("kbs")
                 .userPw("1111")
                 .userName("고범석")
                 .userAddress("서울시 강남")
                 .userEmail("kbs@naver.com")
                 .userJumin("970000-0000000")
                 .userPhone("010-1234-5678")
                 .userGender("남")
                 .build();
			 
	
		Product product1= Product.builder()
						.productName("아름다운사실")
						.productContent("명곡입니다.")
						.productReply("아름다워요")
						.productStar("5")
						.productArtist("부활")
						.build();
		
			
		 Vote vote = Vote.builder()
				 		  .voteTot(250)
				 		  .voteDate(localDate)
				 		  .build();
		vote.setUser(user1);
		vote.setProduct(product1);
		em.persist(user1);
		em.persist(product1);
		em.persist(vote);
		
		Vote insertVote = voteServiceImpl.createVote(vote);
		em.persist(insertVote);
		System.out.println("~~~~~~~~~~~~~~~"+insertVote);
		
	}
	
	

}
