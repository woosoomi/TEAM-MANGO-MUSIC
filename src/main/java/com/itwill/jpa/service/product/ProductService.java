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
	Long checkLikeService(Long productNo);
	// 품절 안내 기능

	Product outOfStockMsg(Long productNo);


	// product 등록
	public Product insertProduct(Product product);
	
	// product 삭제
	public void delete(Long productNo);
	
	// product 업데이트
	public Product updateProduct(Product product);
	
	// product category별 분류
	public List<Product> findByCategory(Long categoryId);
	
	// product 조회수 올리기[성공]
	public Product increaseReadCount(Product product);
	
	// product 조회수별 내림차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountDesc();
	
	// product 조회수별 오름차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountAsc();
	
	// 키워드로 검색[테스트중]
	public List<Product> searchProductsByKeyword(String keyword);
	
}
