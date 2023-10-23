package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

	List<Delivery> findByUserId(String userId);
}
