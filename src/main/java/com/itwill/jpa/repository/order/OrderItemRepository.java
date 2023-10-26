package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	List<OrderItem> findByOrder(Order order);
	
//	List<OrderItem> findByUserId(String userId);
	
	List<OrderItem> findByOrder(OrderDto order);



}
