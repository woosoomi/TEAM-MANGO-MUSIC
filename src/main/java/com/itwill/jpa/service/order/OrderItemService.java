package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemService {

	OrderItem saveOrderItem(OrderItem orderItem);
	
	OrderItem updateOrderItem(OrderItem orderItem);
	
	void deleteOrderItem(Long id) throws Exception;
	
	List<OrderItem> orderItem(Long userId);
	
	OrderItem findOrderItem(Long id);
}
