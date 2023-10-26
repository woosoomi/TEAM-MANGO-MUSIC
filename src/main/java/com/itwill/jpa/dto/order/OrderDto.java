package com.itwill.jpa.dto.order;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
//웹에서 고객에게 보여주기 위한 정보를 담은 객체(Dto)
public class OrderDto {

	private Long orderId;
	
	private int orderPrice;
	
	private OrderStatus orderStatus; //주문 상태

	private String userName;

	private String userPhone;

	private String userAddress;
		
	
	//private List<OrderItem> orderItems; // 주문한 아이템 정보들(수량, 가격등)
	//private List<OrderItemDto> orderItems;
	
	//private List<Coupon> coupons;// 쿠폰들
	
	//Dto에서 고객에게 보여주는 주문 정보들이 어떤값인지를 설정하는 생성자(초기화)
	public OrderDto(Order order) {
		this.orderId = order.getOrderId();
		this.orderPrice = order.getOrderPrice();
		this.orderStatus = order.getOrderStatus();
		this.userName = order.getUser().getUserName();
		this.userPhone = order.getUser().getUserPhone();
		this.userAddress = order.getUser().getUserAddress();
		//this.coupons = order.getCoupons();
		//this.orderItems = order.getOrderItems();
		// 주문 아이템(OrderItem)엔티티를 OrderItemDto로 변환하여 리스트로 저장
		// why? 데이터 무결성을 위해서 Entity는 건들지않고 Dto만 사용하기위해서
		//this.orderItems = order.getOrderItems().stream().map(OrderItemDto::fromOrderItem).collect(Collectors.toList());
	}
	
}
	
		

	
	

					
			

			
