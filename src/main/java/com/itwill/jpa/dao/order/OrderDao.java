package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Order;

public interface OrderDao {

		Order insertOrder(Order order);
		
		Order selectOrder(Long no);
		
		Order updateOrder(Order order) throws Exception;
		
		void deleteOrder(Long no) throws Exception;
		
		List<Order> selectList();
				
}
