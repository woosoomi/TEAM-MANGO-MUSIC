package com.itwill.jpa.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
