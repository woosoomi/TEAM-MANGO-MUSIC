package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.repository.product.ProductVoteRepository;
import com.itwill.jpa.service.vote.VoteServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootTest
class ProductVoteServiceTest {

	@Autowired
	ProductServiceImpl productServiceImpl;
    
	
	@Autowired 
	VoteServiceImpl voteServiceImpl;
	
	@Autowired
    private ProductVoteRepository productVoteRepository;	
	
    //product내 VoteId 수정 Vote Join [성공]   
    @Test
    @Transactional
    @Rollback(false)
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

    
    
}