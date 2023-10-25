package com.itwill.jpa.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//    Product insertProduct(Product product);

//    Product findById(Long productNo);
    
	List<Product> findAll();
// productNo로 찾기
	Optional<Product> findById(Long productNo);
	
//	productName로 찾기
	Product findByProductName(String productName);
	
//	productArtist로 찾기
	Product findByProductArtist(String productArtist);
	
//	category로 찾기
	List<Product> findByProductCategory(ProductCategory categoryId);	

//	keyword가 포함된 product 찾기
    List<Product> findByProductNameContaining(String keyword);
}
