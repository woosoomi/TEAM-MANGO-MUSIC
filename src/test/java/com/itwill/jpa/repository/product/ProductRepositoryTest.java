package com.itwill.jpa.repository.product;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.entity.product.ProductCategory;

import jakarta.transaction.Transactional;

class ProductRepositoryTest extends TeamProjectMangoApplicationTest{

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductCategoryRepository categoryRepository;
	
	@Test
	@Transactional
	@Rollback(false)
	void productInsertTest() {
		ProductCategory productCategory1 = ProductCategory.builder()
				.productCategoryName("music").build();
		
		ProductCategory productCategory2 = ProductCategory.builder()
				.productCategoryName("goods").build();
	}

}
