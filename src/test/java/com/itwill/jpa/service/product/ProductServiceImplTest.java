package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;
@SpringBootTest
class ProductServiceImplTest {
	@Autowired
	ProductServiceImpl productServiceImpl;
    @Autowired
    
    private ProductRepository productRepository;	

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void searchProductsByKeywordTest() {
		String keyword = "음악 제품 설명1";
		List<Product> products = productServiceImpl.searchProductsByKeyword(keyword);
		System.out.println("검색결과>>>" + products);
	}
	@Test
//	@Transactional
//	@Rollback(false)
//	@Disabled
	public void testGetProductOrderByReadCountDesc() {
		List<Product> products = productServiceImpl.getProductOrderByReadCountDesc();
		for (Product product : products) {
			System.out.println("Product Name : " + product.getProductName() + "///Read Count : " + product.getReadCount());
		}
	}
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	public void testGetProductOrderByReadCountAsc() {
		List<Product> products = productServiceImpl.getProductOrderByReadCountAsc();
		for (Product product : products) {
			System.out.println("Product Name : " + product.getProductName() + "///Read Count : " + product.getReadCount());
		}
	}
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	    public void testIncreaseReadCount() {
		 	Optional<Product> productOptional = productRepository.findById(1L);
		 	if(productOptional.isPresent()) {
		 		// 엔티티가 존재할 경우
		 		Product product = productOptional.get();
		 		// readCount 증가
		 		product.setReadCount(product.getReadCount() + 1);
		 		// 변경사항 저장
		 		productRepository.save(product);
		 	}else {
		 		// 엔티티 못찾았을 경우의 예외처리		 		
		 	}
	    }	
}
