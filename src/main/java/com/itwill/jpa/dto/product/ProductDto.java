package com.itwill.jpa.dto.product;

import com.itwill.jpa.entity.product.Product.Music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
	
	private Long productNo;
	private String productName;
	private int productPrice;
	private Long readCount;
	
	
	
//	private String productName;
}
