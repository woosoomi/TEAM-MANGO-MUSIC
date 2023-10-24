package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itwill.jpa.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//    Product insertProduct(Product product);

//    Product findOne(Long productNo);
    
	List<Product> findAll();

//    Product findbyId(Long productNo);

//	keyword가 포함된 title 찾기
    List<Product> findByProductNameContaining(String keyword);
}
