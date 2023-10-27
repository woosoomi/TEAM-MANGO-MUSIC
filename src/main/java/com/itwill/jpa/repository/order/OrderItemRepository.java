package com.itwill.jpa.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	
//	List<OrderItem> findByUserIds(String userId);

//	List<OrderItem> findByOrder(Order order);
	

}
