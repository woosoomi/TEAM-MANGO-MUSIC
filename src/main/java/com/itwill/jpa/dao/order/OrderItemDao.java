package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemDao {

	OrderItem insertOrderItem(OrderItem orderItem);
	
	OrderItem selectOrderItem(Long orderItemId);
	
	OrderItem updateOrderItem(OrderItem orderItem);
	
	void deleteOrderItem(Long orderItemId);
	
	List<OrderItem> selectList();
}
