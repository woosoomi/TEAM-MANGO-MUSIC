package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemDao {

	OrderItem insertOrderItem(OrderItem orderItem);
	
	OrderItem selectOrderItem(Long orderItemNo);
	
	OrderItem updateOrderItem(OrderItem orderItem);
	
	void deleteOrderItem(Long orderItemNo);
	
	List<OrderItem> selectList();
}
