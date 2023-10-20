package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.repository.product.ProductRepository;

@Service
public class ProductService{
	@Autowired
	private ProductRepository productRepository;
}
