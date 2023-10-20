package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Delivery;

public interface DeliveryDao {
	
	Delivery insertDelivery(Delivery delivery);
	
	Delivery selectDelivery(Long deliveryId);
	
	Delivery updateDelivery(Delivery updateDelivery) throws Exception;
	
	void deleteDelivery(Long deliveryId) throws Exception;
	
	List<Delivery> selectList();
}
