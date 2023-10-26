package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
import lombok.ToString;
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
		Order order = orderDao.selectOrder(1L);
		orderItem.setOiId(null);
		orderItem.setOiQty(3);
		
		OrderItem orderItem2 = new OrderItem();
		Order order2 = orderDao.selectOrder(1L);
		orderItem2.setOiId(null);
		orderItem2.setOiQty(5);
		
		orderItem.setOrder(order);
		orderItem2.setOrder(order2);
		
		OrderItem savedOrderItem = orderItemService.saveOrderItem(orderItem);
		OrderItem savedOrderItem2 = orderItemService.saveOrderItem(orderItem2);
		System.out.println(savedOrderItem);
		System.out.println(savedOrderItem2);
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update(){
		OrderItem orderItem = orderItemService.findOrderItem(1L);
		orderItem.setOiQty(8);
		
		OrderItem updateOrderItem = orderItemService.updateOrderItem(orderItem);
		System.out.println(updateOrderItem);
		
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void delete() throws Exception{
		orderItemService.deleteOrderItem(1L);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deleteAll() throws Exception{
		orderItemService.deleteAllOrderItem();
	}

	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findOrderItem() {
		OrderItem findItem = orderItemService.findOrderItem(1L);
		System.out.println(findItem);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void orderItems() {
		List<OrderItem> orderItems = orderItemService.orderItems(1L);
		System.out.println("오더아이템들-->"+orderItems);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void orderItems2() {
		List<OrderItem> orderItems = orderItemService.orderItems("why3795");
		System.out.println(orderItems);
	}
	
}
