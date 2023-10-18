package com.itwill.jpa.dao.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.OrderRepository;

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Order> selectList() {
		return orderRepository.findAll();
	}
	
	@Override
	public Order insertOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}

	@Override
	public Order selectOrder(Long no) {
		Order selectedOrder = orderRepository.findById(no).get();
		return selectedOrder;
	}

	@Override
	public void deleteOrder(Long no) throws Exception {
		Optional<Order> selectedOrderOptional = orderRepository.findById(no); 
		if(selectedOrderOptional.isEmpty()) {
			throw new Exception("존재하지않는주문입니다.");
		}
		orderRepository.delete(selectedOrderOptional.get());
	}

	@Override
	public Order updateOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
