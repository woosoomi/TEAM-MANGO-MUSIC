package com.itwill.jpa.service.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
//@RequiredArgsConstructor
public interface ProductService {
	//List<ProductDao> getAllMusicByProductNoDesc();  // 음악 내립차순 정렬
	
	
}
