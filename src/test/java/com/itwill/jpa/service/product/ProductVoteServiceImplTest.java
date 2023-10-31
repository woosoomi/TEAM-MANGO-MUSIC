package com.itwill.jpa.service.product;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

class ProductVoteServiceImplTest extends TeamProjectMangoApplicationTest {
	@Autowired
	ProductRepository productRepository;

	
	@Autowired
	ProductVoteServiceImple productVoteServiceImple;
	
	/******************* Vote ***********************/

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	// 상품에서 음악 조회수(readCount), 음악 별점(productStar)의 합산해서 Top 20명 추출
	public void testfindTop20ByTotalScore() {

		//System.out.println(">>>>>>>>>>" + productVoteServiceImple.findbyTop20ByTotalScore());

		// System.out.println(">>>>>>>>>>"+productRepository.findByProductVoteId(1L));

	}

	
	

	@Test
	@Transactional
	@Rollback(false)
	void testFindByProductVoteId(Long voteId) {
		//System.out.println(">>>>>" + productRepository.findByProduct_VoteId(1L));
    
	}
}
