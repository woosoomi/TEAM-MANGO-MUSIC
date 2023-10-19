package com.itwill.jpa.repository.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.product.Product;

class ProductRepositoryTest extends TeamProjectMangoApplicationTest {
	@Autowired
	ProductRepository productRepository;
	
	
	@Test
//	@Disabled
	@Transactional
	@Rollback(false)
	void testSave() {
		Product product = Product.builder()
				.productName("aaa")
				.productPrice(1000)
				.build();
		
		System.out.println(product);
		productRepository.save(product);
		
	}

}
