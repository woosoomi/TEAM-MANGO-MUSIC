package com.itwill.jpa.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.repository.product.ProductRepository;


import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
//@RequiredArgsConstructor
public interface ProductService{
	
	@Transactional
//Product//	
	ProductDto getProduct(Long productNo); 
	
	ProductDto saveProduct(ProductDto productDto);
	
	ProductDto updateProduct(Product product) throws Exception;
	
	void deleteProduct(Long productNo) throws Exception;
	
	List<ProductDto> productList(); 
	
	
	

}
