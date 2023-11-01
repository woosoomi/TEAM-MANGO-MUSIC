package com.itwill.jpa.repository.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	List<OrderItem> findByOrder(Order order);
	
//	List<OrderItem> findByUserId(String userId);
	
//	List<OrderItemDto> findByOrder(OrderDto order);
	
//	//유저아이디와 카테고리번호로 주문아이템 찾기
//	@Query("SELECT oi FROM OrderItem oi WHERE oi.order.user.userId = :user_id AND oi.product.productCategory.categoryId = :category_id")
//	List<OrderItem> findByUserIdAndProductCategoryId(@Param("user_id") String userId, @Param("category_id") Long categoryId);

}
