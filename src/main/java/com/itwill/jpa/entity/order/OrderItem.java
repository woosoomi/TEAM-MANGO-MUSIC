package com.itwill.jpa.entity.order;



import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
	@Id
	@SequenceGenerator(name = "ORDER_ITEM_NO_SEQ",sequenceName = "ORDER_ITEM_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ITEM_NO_SEQ")
	private Long oiId;
	
	private int oiQty;

	/*
	 * 다대일 관계
	 */
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_no")
	private Product product;
	
	/*
	 * DTO -> ENTITY로 변환해주는 작업
	 */
	public static OrderItem toEntity(OrderItemDto dto) {
		return OrderItem.builder()
				.oiId(dto.getOiId())
				.oiQty(dto.getOiQty())
				.product(Product.builder().productNo(dto.getProductNo()).build()) // productNo 설정
				.order(Order.builder().orderId(dto.getOrderId()).build()) // orderId 설정
				.build();
				
	}


}
