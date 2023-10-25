package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrdersByUser(User user);
	List<Order> findAllByOrderByCreatedAtDesc();
	List<Order> findAllByOrderByCreatedAtAsc();
}
