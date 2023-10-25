package com.itwill.jpa.repository.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itwill.jpa.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//    Product insertProduct(Product product);

//    Product findById(Long productNo);
    
	List<Product> findAll();

	Optional<Product> findById(Long productNo);
	
	Product findByProductName(String productName);

	Product findByProductArtist(String productArtist);

//	keyword가 포함된 product 찾기
    List<Product> findByProductNameContaining(String keyword);
}
