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
	public Order insertOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder;
	}
	
	@Override
	public Order selectOrder(Long orderId) {
		Order selectedOrder = orderRepository.findById(orderId).get();
		return selectedOrder;
	}
	
	//관리자 권한(오더 수정)
	@Override
	public Order updateOrder(Order updateOrder) throws Exception {
		Optional<Order> findOrderOptional =
				orderRepository.findById(updateOrder.getOrderId());
		Order updatedOrder=null;
		if(findOrderOptional.isPresent()) {
			Order order = findOrderOptional.get();
			//관리자가 수정할 수 있는 주문 정보(주문상태)
			order.setOrderStatus(updateOrder.getOrderStatus());
			updatedOrder=orderRepository.save(order);
		}else {
			throw new Exception("존재하지 않는 주문입니다.");
		}
		return updatedOrder;
	}

	@Override
	public void deleteOrder(Long orderId) throws Exception {
		Optional<Order> selectedOrderOptional = orderRepository.findById(orderId); 
		if(selectedOrderOptional.isEmpty()) {
			throw new Exception("존재하지않는주문입니다.");
		}
		orderRepository.delete(selectedOrderOptional.get());
	}

	@Override
	public List<Order> selectList() {
		return orderRepository.findAll();
	}

}
