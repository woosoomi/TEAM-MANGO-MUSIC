package com.itwill.jpa.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.service.product.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRestController2 {
	@Autowired
	private ProductService productService;
	
//	@GetMapping
//	public ResponseEntity<List<Product>> getMusicList(){
//		ProductCategory productCategory = 
//		productService.findByProductCategory();
//		List<Product> productList = ;
//		return ResponseEntity.status(HttpStatus.OK).body(productList);
//	}

	@PostMapping
	public ResponseEntity<Product> createMusic(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.insertProduct(product));
	}

	



}
