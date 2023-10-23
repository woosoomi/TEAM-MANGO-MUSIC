package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.OrderRepository;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order) throws Exception{
		return null;
	}

	@Override
	public void deleteOrder(Long orderId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllOrder() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> OrdersByUserId(String UserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
