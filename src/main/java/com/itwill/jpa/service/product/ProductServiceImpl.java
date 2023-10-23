package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductDto saveProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ProductDto getProduct(Long productNo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProductDto> productList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ProductDto updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
