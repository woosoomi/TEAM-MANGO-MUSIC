package com.itwill.jpa.dao.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product insertProduct(Product product) {
		Product insertProduct = productRepository.save(product);
		return insertProduct;
	}
	
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		
	}
	
	@Override
	public Product selectProduct(Long productNo) {
		Product selectProduct = productRepository.findById(productNo).get();
		return selectProduct;
	}

	@Override
	public List<Product> selectList() {
	
		return	productRepository.findAll();
	}
}
