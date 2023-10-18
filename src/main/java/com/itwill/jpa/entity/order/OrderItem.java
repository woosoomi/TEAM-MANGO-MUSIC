package com.itwill.jpa.entity.order;


import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long oino;
	private Long oiqty;

	@ManyToOne
	@JoinColumn(name = "order_no")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_no")
	private Product product;
	
}
