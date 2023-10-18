package com.itwill.jpa.dao.product;

import java.util.List;

import com.itwill.jpa.entity.product.Product;

public interface ProductDao {
	
	Product insertProduct(Product product);
	Product selectProduct(Long no);
	
	List<Product> selectList();
	
	void deleteProduct(Long no) throws Exception;
	
}
