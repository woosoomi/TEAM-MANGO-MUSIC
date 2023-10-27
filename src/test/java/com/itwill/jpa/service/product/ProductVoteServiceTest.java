package com.itwill.jpa.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductVoteRepository;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.service.vote.VoteServiceImpl;

@SpringBootTest
class ProductVoteServiceTest {

	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@Autowired 
	VoteServiceImpl voteServiceImpl;

	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRepository userRepository;
		
	
	@Autowired
    private ProductVoteRepository productVoteRepository;	
	
	
	/*
    //product내 VoteId 수정 Vote Join [성공]   
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    public void testUpdateProduct() {
    	Vote vote1 = Vote.builder()
				 .voteId(1L)
				 .voteTot(320)
				 .build();
    	voteServiceImpl.createVote(vote1);
    	
    	// 수정
    	Long productNo = 1L;
        Product product = productServiceImpl.getProduct(productNo);
        product.setProductName("수정 테스트완료");
        product.setVote(vote1);

        // updateProduct 메서드 호출
        Product updatedProduct = productServiceImpl.updateProduct(product);
        
        productVoteRepository.findProductVoteId(1L);
        System.out.println(productVoteRepository.findProductVoteId(1L));
    }
    
    */
	
	/*
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    public void testfindProductVoteIdWithUser() {
    	
    	Vote vote1 = Vote.builder()
				 .voteId(1L)
				 .voteTot(320)
				 .build();
    	voteServiceImpl.createVote(vote1);
    	
    	// User 생성
    	User user = new User();
        user.setUserId("vote");
        user.setUserPw("vote");
        user.setUserName("vote테스트님");
        user.setUserPhone("010-1234-5678");
        user.setVote(vote1);
        userDao.createUser(user);
    	System.out.println("@@@"+user);  
    	
    	// product VoteId 수정
      	Long productNo = 1L;
        Product product = productServiceImpl.getProduct(productNo);
 
        product.setProductStar(20);
        product.setProductName("수정 테스트완료");
        product.setVote(vote1);
       
        
        

        // updateProduct 메서드 호출
        productServiceImpl.updateProduct(product);
          
        productVoteRepository.findProductVoteId(1L);
          
        //findProductVoteIdWithUser
        //productVoteRepository.findProductVoteIdWithUser(1L);
       // System.out.println(">>>>> "+productVoteRepository.findProductVoteIdWithUser(1L));
        
    	List<Product> a = productVoteRepository.selectVoteTop20();
    	System.out.println("@@@@@"+a); 
    
    }
    */
	
	/*
    @Test
    @Transactional
    @Rollback(false)
   // @Disabled
    public void testfindTop20ByTotalScore() {
    	List<Product> a = productVoteRepository.findTop20ByTotalScore();
    	System.out.println("@@@@@"+a); 
    }
    */
}