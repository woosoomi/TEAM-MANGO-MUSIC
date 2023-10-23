package com.itwill.jpa.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.repository.product.ProductRepository;


import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService{
	
	private final ProductRepository productRepository;
	
	@Transactional
//Product//	
	public void insertProduct(Product product) {
		((ProductService) productRepository).insertProduct(product);
	}
	
	public List<Product> findProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> findOneProduct(Long productNo) {
		return productRepository.findById(productNo);
	}
	

}
