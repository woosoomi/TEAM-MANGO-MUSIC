package com.itwill.jpa.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.order.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
