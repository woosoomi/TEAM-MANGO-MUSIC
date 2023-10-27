package com.itwill.jpa.dao.product;

import java.util.List;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Ticket;

public interface ProductDao {

	Product insertProduct(Product product);
	
	Product selectProduct(Long productNo);
	
	Product updateProduct(Product product) throws Exception;
	
	void deleteProduct(Long productNo) throws Exception;
	
	List<Product> selectList();
	
	List<Product> getProductByCategoryId(Long categoryId);
	
	List<Ticket> getTicketByCategoryId(Long categoryId);
	
	List<Goods> getGoodsByCategoryId(Long categoryId);

}
