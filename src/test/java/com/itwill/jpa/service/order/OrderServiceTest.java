package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;

class OrderServiceTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	UserRepository userRepository;
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
