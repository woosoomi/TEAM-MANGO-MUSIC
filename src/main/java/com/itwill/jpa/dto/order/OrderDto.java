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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//웹에서 고객에게 보여주기 위한 정보를 담은 객체
public class OrderDto {

	private String username;

	private String userphone;

	private String useraddress;

	private LocalDateTime orderdate;

	private OrderStatus orderstatus;

	private List<OrderItem> orderitems; // 주문한 아이템 정보들(수량, 가격등)

	//고객 주문 정보의 정의(초기화)
	public OrderDto(Order order) {
		this.username = order.getUser().getUsername();
		this.userphone = order.getUser().getUserphone();
		this.useraddress = order.getUser().getUseraddress();
		this.orderdate = order.getOrderdate();
		this.orderstatus = order.getOrderstatus();
		// 주문 아이템(OrderItem)을 OrderItemDto로 변환하여 리스트로 저장
		//this.orderitems = order.getOrderitems().stream().map(OrderItemDto::fromOrderItem).collect(Collectors.toList());

	}
	
}
	

					
			

			
