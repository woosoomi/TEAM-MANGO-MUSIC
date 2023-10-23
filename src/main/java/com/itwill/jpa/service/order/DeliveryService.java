package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.user.User;

public interface DeliveryService {
	
	Delivery saveDelivery(Delivery delivery);
	
	Delivery updateDelivery(Delivery delivery) throws Exception;
	
	void deleteDelivery(Long id) throws Exception;
	
	List<Delivery> deliverys();
	
	List<Delivery> findDelivery(String userId);
	
	Delivery findByDeliveryId(Long id);
	
	
	
}