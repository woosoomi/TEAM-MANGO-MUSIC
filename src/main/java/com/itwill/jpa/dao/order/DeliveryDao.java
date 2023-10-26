package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;

public interface DeliveryDao {
	
	Delivery insertDelivery(Delivery delivery);
	
	DeliveryDto updateDelivery(DeliveryDto updateDeliveryDto) throws Exception;
	
	void deleteDelivery(Long DeliveryDtoId) throws Exception;
	
	void selectList();
	
	List<DeliveryDto> getDeliveriesByUserId(String userId);
	
	DeliveryDto findByDeliveryId(Long id);
}
