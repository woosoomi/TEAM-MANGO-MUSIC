package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

//	List<OrderItem> findByOrder(Long orderId);
}
