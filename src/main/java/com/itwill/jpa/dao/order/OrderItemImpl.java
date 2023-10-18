package com.itwill.jpa.dao.order;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.repository.order.OrderItemRepository;

public class OrderItemImpl implements OrderItemDao{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem insertOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		return savedOrderItem;
	}

}
