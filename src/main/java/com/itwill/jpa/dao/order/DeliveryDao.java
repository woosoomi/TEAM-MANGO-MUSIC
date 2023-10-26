package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;

public interface DeliveryDao {
	
	DeliveryDto insertDelivery(DeliveryDto delivery);
	
	DeliveryDto updateDelivery(DeliveryDto updateDeliveryDto) throws Exception;
	
	void deleteDelivery(Long DeliveryDtoId) throws Exception;
	
	List<DeliveryDto> selectList();
	
	List<DeliveryDto> getDeliveriesByUserId(String userId);
	
	DeliveryDto findByDeliveryId(Long id);
}
