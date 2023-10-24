package com.itwill.jpa.dao.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao{
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> selectList(){
		return null;
	}
	// 제품 등록
	@Override
	public Product insertProduct(Product product) {
		Product insertProduct = productRepository.save(product);
		return insertProduct;
	}
	// 제품 조회
	@Override
	public Product selectProduct(Long productNo) {
		Product selectProduct = productRepository.findById(productNo).get();
		return selectProduct;
	}
	// 제품 업데이트
	@Override
	public Product updateProduct(Product product) throws Exception {
		Optional<Product> findProductOptional = productRepository.findById(product.getProductNo());
		Product updateProduct=null;
		if(findProductOptional.isPresent()) {
			Product findProduct = findProductOptional.get();
			findProduct.setProductName(product.getProductName());
			product=productRepository.save(findProduct);
		}else {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		return updateProduct;
	}
	// 제품 삭제
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		Optional<Product> selectProductOptional= productRepository.findById(productNo);
		if(selectProductOptional.isEmpty()) {
			throw new Exception("존재하지 않는 제품입니다.");
		}
		productRepository.delete(selectProductOptional.get());
	}

}
