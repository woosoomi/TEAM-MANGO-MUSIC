package com.itwill.jpa.entity.order;


import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long oiNo;
	private Long oiQty;

	@ManyToOne
	@JoinColumn(name = "order_no")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_no")
	private Product product;
	
	public static OrderItem toEntity(OrderItemDto orderItemDto) {
		return OrderItem.builder()
				.oiQty(orderItemDto.getOiQty())
				.build();
				
	}
	   /*
	   public double calculateTotalPrice() {
	    double totalPrice = 0.0;
	    
	    for (OrderItem item : orderItems) {
	        if (item.getProduct() != null) {
	            totalPrice += item.getProduct().getPrice() * item.getQuantity();
	        } else {
	            throw new IllegalStateException("주문 하실 상품이 없습니다.");
	        }
	    }
	    
	    return totalPrice;
	}
	*/

}
