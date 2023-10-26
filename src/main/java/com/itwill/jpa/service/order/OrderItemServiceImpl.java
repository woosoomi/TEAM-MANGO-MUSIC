package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderItemDao;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemDao orderItemDao;

	//아이템 추가
	@Override
	public OrderItemDto saveOrderItem(OrderItemDto orderItem) {
		return orderItemRepository.save(orderItem);
	}

	//아이템 업데이트
	@Override
	public OrderItemDto updateOrderItem(OrderItemDto orderItem) {
		return orderItemDao.updateOrderItem(orderItem);
	}
	
	//아이템아이디 받아와서 삭제
	@Override
	public void deleteOrderItem(Long id) throws Exception {
		orderItemDao.deleteOrderItem(id);
	}
	
	//유저 아이디 아이템 모두 삭제
	@Override
	public void deleteAllOrderItem() throws Exception {
		orderItemDao.deleteAll();
		
	}

	//아이템 아이디로 아이템 선택하기
	@Override
	public OrderItemDto findOrderItem(Long id) {
		return orderItemDao.selectOrderItem(id);
	}

	//오더 아이디를 받아와서 아이템리스트 나열
	@Override
	public List<OrderItemDto> orderItems(Long orderId) {
		return orderItemDao.orderItems(orderId);
	}

	@Override
	public List<OrderItemDto> orderItems(String userId) {
		return orderItemDao.orderItems(userId);
	}

	

	
}