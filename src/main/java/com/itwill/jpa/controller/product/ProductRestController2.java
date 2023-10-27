package com.itwill.jpa.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
//		return ResponseEntity.status(HttpStatus.OK).body(productList);
//	}

	@PostMapping
	public ResponseEntity<Product> createMusic(@RequestBody Product product){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(productService.insertProduct(product));
	}
	//나중에 뮤직dto쪽에 연결해서 쓸 생각 - 서비스에도 dto 연결 필요
	

	@PutMapping
	public ResponseEntity<Product> updateProduct(@RequestBody Product updateProduct)throws Exception{
		return ResponseEntity.status(HttpStatus.OK)
				.body(productService.updateProduct(updateProduct));
	}

	@DeleteMapping("/{productNo}")
	public ResponseEntity<Map> deleteProduct(@PathVariable(name="productNo") Long productNo) throws Exception{
		productService.deleteProduct(productNo);
		return ResponseEntity.status(HttpStatus.OK).body(new HashMap<>());
	}
	
	//product 단일 기능 셋
	
}
