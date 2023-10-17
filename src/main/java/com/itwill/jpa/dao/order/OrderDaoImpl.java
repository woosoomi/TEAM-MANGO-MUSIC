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
	public Order updateOrder(Order updateOrder) throws Exception {
		Optional<Order> findOrderOptional =
				orderRepository.findById(updateOrder.getOrderid());
		Order updatedOrder=null;
		if(findOrderOptional.isPresent()) {
			Order order = findOrderOptional.get();
			//order.setOrdername(updateOrder.getOrderid());
			updatedOrder=orderRepository.save(order);
		}else {
			throw new Exception("존재하지않는주문입니다.");
		}
		return updatedOrder;
	}
	
	@Override
	public void deleteOrder(Long no) throws Exception {
		Optional<Order> selectedOrderOptional = orderRepository.findById(no); 
		if(selectedOrderOptional.isEmpty()) {
			throw new Exception("존재하지않는주문입니다.");
		}
		orderRepository.delete(selectedOrderOptional.get());
	}


}
