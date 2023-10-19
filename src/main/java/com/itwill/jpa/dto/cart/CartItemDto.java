package com.itwill.jpa.dto.cart;

import com.itwill.jpa.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CartItemDto {
	
	private int cartItemQty;
	private Product product;

	
}
