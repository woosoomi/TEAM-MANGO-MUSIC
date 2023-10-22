package com.itwill.jpa.service.product;

import java.util.List;

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
		productRepository.insertProduct(product);
	}
	
	public List<Product> findProducts() {
		return productRepository.findAll();
	}
	
	public Product findOneMusic(Long productNo) {
		return productRepository.findOne(productNo);
	}
	//Music//	
		public void insertMusic(Music music) {
			productRepository.insertMusic(music);
		}
		
		public List<Music> findMusics() {
			return productRepository.findAllMusic();
		}
		
		public Product findOneProduct(Long productNo) {
			return productRepository.findOne(productNo);
		}	
}
