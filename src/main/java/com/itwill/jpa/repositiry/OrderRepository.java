package com.itwill.jpa.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
