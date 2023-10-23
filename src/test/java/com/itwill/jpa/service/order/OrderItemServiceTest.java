package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.Order.OrderStatus;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;
@SpringBootTest
@Transactional
class OrderItemServiceTest {

	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		OrderItem orderItem = new OrderItem();
		Order order = orderDao.selectOrder(null);
		orderItem.setOiId(null);
		orderItem.setOiQty(3);
		
//	
		
//		orderItem.setOrder(order);
		OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
		System.out.println(savedOrderItem);
	}

}
