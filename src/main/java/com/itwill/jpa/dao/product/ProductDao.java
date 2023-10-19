package com.itwill.jpa.dao.product;

import java.util.List;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Music;

public interface ProductDao {
	
	Product insertProduct(Product product);
	
	Product selectProduct(Long productNo);
	
	List<Product> selectList();
	
	void deleteProduct(Long productNo) throws Exception;
	
//	List<ProductDao> getAllMusicByProductNoDesc(); // 음악 내립차순 정렬
	
}
