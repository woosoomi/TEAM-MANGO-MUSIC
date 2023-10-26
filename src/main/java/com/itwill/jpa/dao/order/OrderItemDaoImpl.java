package com.itwill.jpa.dao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.exception.order.OrderItemNotFoundException;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;
@Repository
public class OrderItemDaoImpl implements OrderItemDao{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	//아이템 추가
	@Override
	public OrderItem insertOrderItem(OrderItem orderItem) {
		OrderItem savedOrderItem = orderItemRepository.save(orderItem);
		return savedOrderItem;
	}

	//아이템 아이디로 아이템 선택하기
	@Override
	public OrderItem selectOrderItem(Long orderItemId) {
		OrderItem selectedOrderItem = orderItemRepository.findById(orderItemId).get();
		return selectedOrderItem;
	}

	//아이템 업데이트
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
			
	//아이템 삭제
	@Override
	public void deleteOrderItem(Long orderItemId) {
		Optional<OrderItem> selectedOrderItemOptional = orderItemRepository.findById(orderItemId);
		if(selectedOrderItemOptional.isEmpty()) {
			throw new OrderItemNotFoundException("삭제하실 상품이 존재하지 않습니다.");
		}
		orderItemRepository.delete(selectedOrderItemOptional.get());
	}
	
	//아이템 모두 삭제
	@Override
	public void deleteAll() {
		orderItemRepository.deleteAll();
	}

	@Override
	public List<OrderItem> orderItems(Long orderId) {
		Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return orderItemRepository.findByOrder(order);
        } else {
            return new ArrayList<>(); // 오더 아이디를 찾지 못한 경우 빈 목록을 반환
        }
	}
	

	

}