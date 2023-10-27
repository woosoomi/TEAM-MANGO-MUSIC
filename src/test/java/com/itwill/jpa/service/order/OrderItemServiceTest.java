package com.itwill.jpa.service.order;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;

class OrderItemServiceTest extends TeamProjectMangoApplicationTest {

	@Autowired
	OrderItemService orderItemService;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	ProductDao productDao;
	
	//오더 아이템 생성 실패
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void insert() {
		
		OrderItem orderItem = new OrderItem();
		
		Order order = orderDao.selectOrder(1L);
		
		Product product = productDao.insertProduct(Product.builder().productNo(36L).build());
		
		orderItem.setOrder(order);
		orderItem.setProduct(product);
		
		OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		
		orderItemDto.setOiId(null);
		orderItemDto.setOiQty(3);

		OrderItemDto savedOrderItemDto = orderItemService.saveOrderItem(orderItemDto);

		System.out.println(savedOrderItemDto);
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
		orderItemService.deleteOrderItem(64L);
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
	
	
}
