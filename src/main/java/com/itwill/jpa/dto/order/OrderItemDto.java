package com.itwill.jpa.dto.order;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.order.OrderItem;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.exception.OrderItemNotFoundException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

	private Long oiQty;
	
	private String productName;
	private int productPrice;
	private String productImg;

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	public OrderItemDto(OrderItem orderItem) {
		this.productName = orderItem.getProduct().getProductName();
		this.productPrice = orderItem.getProduct().getProductPrice();
//		this.img = orderItem.getProduct().getImg();
	}
	
	   public double calculateTotalPrice() {
		    double totalPrice = 0.0;
		    
		    for (OrderItem item : orderItems) {
		        if (item.getProduct() != null) {
		            totalPrice += item.getProduct().getProductPrice() * item.getOiQty();
		        } else {
		            throw new OrderItemNotFoundException("주문 하실 상품이 없습니다.");
		        }
		    }
		    
		    return totalPrice;
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
