package com.itwill.jpa.dao.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.exception.order.OrderItemNotFoundException;
import com.itwill.jpa.repository.order.OrderItemRepository;

public class OrderItemImpl implements OrderItemDao{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Override
	public OrderItem insertOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		return savedOrderItem;
	}

	@Override
	public OrderItem selectOrderItem(Long orderItemId) {
		OrderItem selectedOrderItem = orderItemRepository.findById(orderItemId).get();
		return selectedOrderItem;
	}

	@Override
	public OrderItem updateOrderItem(OrderItem updateOrderItem) {
		Optional<OrderItem> findOrderItemOptional =
				orderItemRepository.findById(updateOrderItem.getOiId());
		OrderItem updatedOrderItem = null;
		if(findOrderItemOptional.isPresent()) {
			OrderItem orderItem = findOrderItemOptional.get();
			orderItem.setOiQty(updateOrderItem.getOiQty());
			updatedOrderItem=orderItemRepository.save(orderItem);
		}else {
			throw new OrderItemNotFoundException("수정하실 상품이 존재하지 않습니다.");
		}
		return updatedOrderItem;
	}
			

	@Override
	public void deleteOrderItem(Long orderItemId) {
		Optional<OrderItem> selectedOrderItemOptional = orderItemRepository.findById(orderItemId);
		if(selectedOrderItemOptional.isEmpty()) {
			throw new OrderItemNotFoundException("삭제하실 상품이 존재하지 않습니다.");
		}
		orderItemRepository.delete(selectedOrderItemOptional.get());
	}

	@Override
	public List<OrderItem> selectList() {
		return orderItemRepository.findAll();
	}

}
