package com.itwill.jpa.dao.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Orders;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;

public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public List<Orders> selectList() {
		return orderRepository.findAll();
	}
	
	@Override
	public Orders insertOrder(Orders order) {
		Orders savedOrder = orderRepository.save(order);
		return savedOrder;
	}

	@Override
	public Orders selectOrder(Long no) {
		Orders selectedOrder = orderRepository.findById(no).get();
		return selectedOrder;
	}

	@Override
	public void deleteOrder(Long no) throws Exception {
		Optional<Orders> selectedOrderOptional = orderRepository.findById(no); 
		if(selectedOrderOptional.isEmpty()) {
			throw new Exception("존재하지않는주문입니다.");
		}
		orderRepository.delete(selectedOrderOptional.get());
	}

	@Override
	public Orders updateOrder(Orders order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
