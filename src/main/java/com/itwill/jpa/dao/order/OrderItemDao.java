package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemDao {

	OrderItemDto insertOrderItem(OrderItemDto orderItem);
	
	OrderItemDto selectOrderItem(Long orderItemId);
	
	List<OrderItemDto> orderItems(Long orderId);
	
	List<OrderItem> orderItems(String userId);
	
	OrderItemDto updateOrderItem(OrderItemDto orderItem);
	
	void deleteOrderItem(Long orderItemId);
	
	void deleteAll();
	
}
