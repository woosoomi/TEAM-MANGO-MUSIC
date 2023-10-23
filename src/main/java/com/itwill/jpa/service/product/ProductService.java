package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;



@Service
@Transactional(readOnly = true)
//@RequiredArgsConstructor
public interface ProductService{
	
	@Transactional
//Product//	
	Product getProduct(Long productNo); 
	
	Product saveProduct(Product productDto);
	
	void deleteProduct(Long productNo) throws Exception;
	
	List<Product> productList(); 
	
	
	// 좋아요 누르기 기능
	Product checkLikeService(Long productNo);
	// 품절 안내 기능

	Product outOfStockMsg(Long productNo);


	
	// 검색 기능
	
	// 키워드로 검색[성공]
	public List<Product> searchProductsByKeyword(String keyword);
	
}
