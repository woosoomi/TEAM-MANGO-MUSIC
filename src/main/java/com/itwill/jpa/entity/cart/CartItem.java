package com.itwill.jpa.entity.cart;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long cartId;
	
	private int cartItemNo;
	private int cartNo;
	private int cartItemQty;
	private Product product;
	@CreationTimestamp
	private LocalDateTime createAt;
	@UpdateTimestamp
	private LocalDateTime updateAt;
}
