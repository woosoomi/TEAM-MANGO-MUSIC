package com.itwill.jpa.dao.product;

import java.util.List;

import com.itwill.jpa.entity.product.Product;

public interface ProductDao {

	Product insertProduct(Product product);
	
	Product selectProduct(Long productNo);
	
	Product updateProduct(Product product) throws Exception;
	
	void deleteProduct(Long productNo) throws Exception;
	
	List<Product> selectList();
}
