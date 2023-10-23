package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;

public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem saveOrderItem(OrderItem orderItem) {

		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrderItem(Long id) throws Exception {
		orderItemRepository.deleteById(id);
	}

	@Override
	public void deleteAllOrderItem() throws Exception {
		orderItemRepository.deleteAll();
	}

	@Override
	public List<OrderItem> orderItems(Order order) {
		List<OrderItem> orderItems = orderItemRepository.findByOrder(order.getOrderId());
		if(orderItems ==null) {
			return new ArrayList<>();
		}
		return orderItems;
	}

	@Override
	public OrderItem findOrderItem(Order order) {
		return orderItemRepository.findById(order.getOrderId()).get();
	}

	
}
