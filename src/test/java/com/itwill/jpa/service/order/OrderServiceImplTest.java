package com.itwill.jpa.service.order;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;

class OrderServiceImplTest extends TeamProjectMangoApplicationTest{

	@Autowired
	OrderServiceImpl orderServiceImpl;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	//주문 생성
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void OrderCreateTest() {
		Order order = new Order();
		User user = new User("149511951","1111","한영","010-1111","안양","why","960410","남", null, null, null, null);
		Delivery delivery = new Delivery(110L, null, null, null, null, user);
		
		order.setOrderPrice(20000);
		order.setDelivery(delivery);
		order.setOrderDate(null);
		order.setOrderId(10001L);
		order.setOrderStatus(OrderStatus.배송준비중);
		order.setUser(user);
		
		userRepository.save(user);
		deliveryRepository.save(delivery);
		Order createdOrder = orderServiceImpl.saveOrder(order);
		System.out.println(createdOrder);
	}
	
	
	//주문 정보 수정(Good!)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void OrderUpdateTest() throws Exception {
		Order order = orderRepository.findById(1L).get();
		order.setOrderPrice(333333333);
		order.setOrderStatus(OrderStatus.결제완료);
		
		Order updatedOrder = orderServiceImpl.updateOrder(order);
		System.out.println(updatedOrder);
	}
	
	//주문 한개 삭제
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void OrderDeleteTest() throws Exception {
		
		
	}



}
