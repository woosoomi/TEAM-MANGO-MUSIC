package com.itwill.jpa.service.order;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
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
		OrderItemDto orderItem = new OrderItemDto();
		Order order = orderDao.selectOrder(1L);
		orderItem.setOiId(null);
		orderItem.setOiQty(3);
		
		OrderItemDto orderItem2 = new OrderItemDto();
		Order order2 = orderDao.selectOrder(1L);
		orderItem2.setOiId(null);
		orderItem2.setOiQty(5);
		
//		orderItem.setOrder(order);
//		orderItem2.setOrder(order2);
		
		OrderItemDto savedOrderItem = orderItemService.saveOrderItem(orderItem);
		OrderItemDto savedOrderItem2 = orderItemService.saveOrderItem(orderItem2);
		System.out.println(savedOrderItem);
		System.out.println(savedOrderItem2);
	}
	
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void update(){
		OrderItemDto orderItem = orderItemService.findOrderItem(1L);
		orderItem.setOiQty(8);
		
		OrderItemDto updateOrderItem = orderItemService.updateOrderItem(orderItem);
		System.out.println(updateOrderItem);
		
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void delete() throws Exception{
		orderItemService.deleteOrderItem(82L);
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
		OrderItemDto findItem = orderItemService.findOrderItem(1L);
		System.out.println(findItem);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void orderItemsByOrderId() {
		List<OrderItemDto> orderItems = orderItemService.orderItemsByOrderId(1L);
		System.out.println("오더아이템들-->"+orderItems);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void orderItemsByUserId() {
		List<OrderItemDto> orderItems = orderItemService.orderItemsByUserId("why3795");
		System.out.println(orderItems);
	}
	
}
