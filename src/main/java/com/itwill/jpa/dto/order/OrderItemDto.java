package com.itwill.jpa.dto.order;

import com.itwill.jpa.entity.order.OrderItem;

import com.itwill.jpa.entity.product.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

	private Long oiqty;
	
	private String name;
	private int price;
	private String img;

	public OrderItemDto(OrderItem orderItem) {
		this.name = orderItem.getProduct().getName();
		this.price = orderItem.getProduct().getPrice();
//		this.img = orderItem.getProduct().getImg();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	//OrderDto에서 OrderItemDto를 쓰기위한 메서드
	//(OrderItem entity를 건들지 않기위해 OrderItemDto를 대신해서 사용 = 데이터 무결성 유지 목적)
	
	/*
	  
    public static OrderItemDto fromOrderItem(OrderItem orderItem) {
    
        OrderItemDto dto = new OrderItemDto();
        dto.setQuantity(orderItem.getQuantity());
        dto.setPrice(orderItem.getPrice());
        return dto;
        
    }
    
    */
}
