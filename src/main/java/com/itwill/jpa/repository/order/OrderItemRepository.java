package com.itwill.jpa.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.order.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{


	//List<OrderItem> findByOrder(Long orderId);

}
