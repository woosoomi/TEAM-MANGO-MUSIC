package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.exception.product.NotEnoughProductStockException;
import com.itwill.jpa.repository.product.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProduct(Long productNo) {
		return productRepository.findById(productNo).get();
	}
	
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		productRepository.deleteById(productNo);
		
	}
	
	@Override
	public List<Product> productList() {
		return productRepository.findAll();
	}
	
	@Override
	public Product checkLikeService(Long productNo) {
		Product findProduct = productRepository.findById(productNo).get();
		int checkLike = findProduct.getProductStar();
		if(checkLike%2==1) {
			
		}else if(checkLike%2==0) {
			
		}
		
		return null;
	}
	
	@Override
	public Product outOfStockMsg(Long productNo) {
		Product findProduct =productRepository.findById(productNo).get();
		int stockCount=findProduct.getProductStock();
		
		if(stockCount==0) {
			throw new NotEnoughProductStockException("품절된 상품입니다.");
		}
		
		return findProduct;
	}
}
