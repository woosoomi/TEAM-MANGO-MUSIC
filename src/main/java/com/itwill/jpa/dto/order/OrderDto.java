package com.itwill.jpa.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

//웹에서 고객에게 보여주기 위한 정보를 담은 객체(Dto)
public class OrderDto {

	private String username;

	private String userphone;

	private String useraddress;

	private LocalDateTime orderdate;

	private OrderStatus orderstatus;

	private List<OrderItem> orderitems; // 주문한 아이템 정보들(수량, 가격등)

	//Dto에서 고객에게 보여주는 주문 정보들이 어떤값인지를 설정(초기화)
	public OrderDto(Order order) {
		this.username = order.getUser().getUserName();
		this.userphone = order.getUser().getUserPhone();
		this.useraddress = order.getUser().getUserAddress();
		this.orderdate = order.getOrderdate();
		this.orderstatus = order.getOrderstatus();
		//OrderItem 엔티티 사용함 추후에 아래방법으로 사용
		this.orderitems = order.getOrderitems();
		// 주문 아이템(OrderItem)엔티티를 OrderItemDto로 변환하여 리스트로 저장
		//this.orderitems = order.getOrderitems().stream().map(OrderItemDto::fromOrderItem).collect(Collectors.toList());
	}
		
}
		

	
	

					
			

			
