package com.itwill.jpa.dao.order;

import java.util.List;

import com.itwill.jpa.entity.order.Orders;

public interface OrderDao {

		Orders insertOrder(Orders order);
		
		Orders selectOrder(Long no);
		
		// 관리자(admin)가 주문상태 변경 수정 가능 (ex.결제완료, 배송준비중, 배송완료 등)
		Orders updateOrder(Orders order) throws Exception;
		
		void deleteOrder(Long no) throws Exception;
		
		List<Orders> selectList();
				
}
