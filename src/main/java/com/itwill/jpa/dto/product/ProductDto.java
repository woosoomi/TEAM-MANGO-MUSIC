package com.itwill.jpa.dto.product;

import com.itwill.jpa.entity.product.Product.Music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProductDto {
	
	private Long productNo;
	private String productName;
	private int productPrice;
	private Long readCount;
	
	public ProductDto(Music music) {
		this.productNo = music.getProductNo();
		this.productName = music.getProductName();
		this.readCount = music.getReadCount();
	}
	
//	private String productName;
}
