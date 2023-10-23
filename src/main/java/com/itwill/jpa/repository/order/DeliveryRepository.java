package com.itwill.jpa.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Delivery;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long>{


//	List<Delivery> findByUserId(String userId);

}