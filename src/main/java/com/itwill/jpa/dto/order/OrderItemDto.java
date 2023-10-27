package com.itwill.jpa.dto.order;

import com.itwill.jpa.entity.order.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {

	private Long oiId;
	
	private int oiQty;
	
	private Long productNo;
	
	private Long orderId;

	
	
	public OrderItemDto(OrderItem orderItem) {
		this.oiId=orderItem.getOiId();
		this.oiQty=orderItem.getOiQty();
		this.productNo = orderItem.getProduct().getProductNo();
		this.orderId = orderItem.getOrder().getOrderId();
		
	}
	
	
	

	
	public static OrderItemDto toDto(OrderItem entity) {
		return OrderItemDto.builder()
				.oiId(entity.getOiId())
				.oiQty(entity.getOiQty())
				.productNo(entity.getProduct().getProductNo())
				.orderId(entity.getOrder().getOrderId())
				.build();
				
	}
	
}
	

	  
    
   
