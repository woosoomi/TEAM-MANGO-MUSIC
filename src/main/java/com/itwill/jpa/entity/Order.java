package com.itwill.jpa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.itwill.jpa.dto.OrderDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long orderno;
	
	private String ordername;
	
	private String orderaddress;
	
	private Long orderprice;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	private String userid;
	
	public static Order toEntity(OrderDto dto) {
		return Order.builder()
			        .ordername(dto.getOrdername())
			        .orderaddress(dto.getOrderaddress())
			        .orderprice(dto.getOrderprice())
			        .build();
		
	}

}
