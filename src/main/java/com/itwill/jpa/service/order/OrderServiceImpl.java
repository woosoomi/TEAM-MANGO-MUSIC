package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	
	//주문 생성
	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	
	//주문 정보 수정
	@Transactional
	@Override
	public Order updateOrder(Order order) throws Exception{
		return orderDao.updateOrder(order);
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
	public List<Order> ordersByUserId(String UserId) {
		return orderDao.getOrdersByUserId(UserId);
	}
	
	//전체 주문 불러오기(관리자)
	@Override
	public List<Order> orders() {
		return orderRepository.findAll();
	}

}
