package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.entity.order.Order;

public interface OrderService {
	//주문 생성
	Order saveOrder(Order order);
	//주문 정보 수정
	Order updateOrder(Order order) throws Exception;
	//주문 한개 삭제
	void deleteOrder(Long orderId) throws Exception;
	//주문 전체 삭제
	void deleteAllOrder() throws Exception;
	//유저 Id로 전체 주문 불러오기
	List<Order> OrdersByUserId(String UserId);


}
