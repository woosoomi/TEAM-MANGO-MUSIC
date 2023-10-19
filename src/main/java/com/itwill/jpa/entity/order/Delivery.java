package com.itwill.jpa.entity.order;


import com.itwill.jpa.dto.order.DeliveryDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder

public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long deliveryNo;
	
	private String deliveryName;
	
	private String deliveryPhone;
	
	private String deliveryAddress;
	
	private String deliveryCompany;
	
	//일대일 양방향 (Order <-> Delivery) FK를 가진 Order가 주인
	@OneToOne
	@JoinColumn(name = "order_no")
	private Orders order;
	
	//Dto -> entity 변환해주는 매서드
	public static Delivery toEntity(DeliveryDto dto) {
		return Delivery.builder()
					   .deliveryName(dto.getDeliveryName())
					   .deliveryPhone(dto.getDeliveryPhone())
					   .deliveryAddress(dto.getDeliveryAddress())
					   .deliveryCompany(dto.getDeliveryCompany())
					   .build();
	}
	
	
}
