package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.dto.order.OrderItemDto;

public interface OrderItemService {

	OrderItemDto saveOrderItem(OrderItemDto orderItem);
	
	OrderItemDto updateOrderItem(OrderItemDto orderItem);
	
	void deleteOrderItem(Long id) throws Exception;
	
	void deleteAllOrderItem() throws Exception;
	
	List<OrderItemDto> orderItems(Long orderId);
	

	List<OrderItemDto> orderItems(String userId);
	
	OrderItemDto findOrderItem(Long id);


}