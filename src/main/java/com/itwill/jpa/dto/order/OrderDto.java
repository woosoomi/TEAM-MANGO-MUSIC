package com.itwill.jpa.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.order.OrderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//웹에서 고객에게 보여주기 위한 정보를 담은 객체
public class OrderDto {

	private String username;

	private String userphone;

	private String useraddress;

	private LocalDateTime orderdate;

	private OrderStatus orderstatus;

	private List<OrderItem> orderItems; // 주문한 아이템 정보들(수량, 가격등)
	
	/*
    // 멤버 필드 초기화 메서드(@AllArgsConstructor 쓰므로 생략)
    public void initializeFields(String username, String userphone, String useraddress, LocalDateTime orderdate, OrderStatus orderstatus, List<OrderItem> orderItems) {
        this.username = username;
        this.userphone = userphone;
        this.useraddress = useraddress;
        this.orderdate = orderdate;
        this.orderstatus = orderstatus;
        this.orderItems = orderItems;
    }
	*/
}
