package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;

public interface DeliveryService {
	
	Delivery saveDelivery(Delivery delivery);
	
	Delivery updateDelivery(Delivery delivery);
	
	void deleteDelivery(Long id) throws Exception;
	
	List<Delivery> deliverys();
	
	Delivery findDelivery(Order order);
	
	List<Delivery> deliverysFindById(Order order);
	
	
}
