package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;
import jakarta.websocket.Session;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;

	//주문 생성
	@Override
	public OrderDto saveOrder(OrderDto dto) {
		
		Order order = orderRepository.save(Order.toEntity(dto));
		OrderDto orderDto = OrderDto.toDto(order);
		return orderDto;
	}
	
	//주문 정보 수정
	@Transactional
	@Override
	public OrderDto updateOrder(OrderDto dto) throws Exception{
		Order order = orderDao.updateOrder(Order.toEntity(dto));
		OrderDto orderDto = OrderDto.toDto(order);
		return orderDto;
	}

	//주문 한개 삭제
	@Override
	public void deleteOrder(Long orderId) throws Exception {
		orderRepository.deleteById(orderId);
	}
	
	//주문 전체 삭제
	@Override
	public void deleteAllOrder() throws Exception {
		orderRepository.deleteAll();
	}

	//유저 아이디로 주문 전체 불러오기
	@Override
	public List<OrderDto> ordersByUserId(String UserId) {
		List<Order> orderList = orderDao.getOrdersByUserId(UserId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}
	
	//전체 주문 불러오기(관리자)
	@Override
	public List<OrderDto> orders() {
		List<Order> orderList = orderRepository.findAll();
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}

	@Override
	public List<OrderDto> orderListByNewer(String userId) {
		List<Order> orderList = orderDao.orderListByNewer(userId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}

	@Override
	public List<OrderDto> orderListByOlder(String userId) {
		List<Order> orderList = orderRepository.orderListByOlder(userId);
		List<OrderDto> orderDtoList = new ArrayList<OrderDto>();
		for (Order order : orderList) {
			orderDtoList.add(OrderDto.toDto(order));
		}
		return orderDtoList;
	}



}
