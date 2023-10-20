package com.itwill.jpa.dto.order;

import java.sql.Date;
import java.time.LocalDateTime;

import com.itwill.jpa.entity.order.Coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
//웹에서 고객에게 보여주기 위한 정보를 담은 객체(Dto)
public class CouponDto {

//	private String couponType;
//	
//	private String couponCode;
//	
//	private Double couponDiscount;
//	
//	private Date couponExpirationDate;
//
//	private int couponIsUsed;
//	
//	private LocalDateTime createdAt;
//
//	private LocalDateTime updatedAt;
//	
//	//Dto에서 고객에게 보여주는 주문 정보들이 어떤값인지를 설정하는 생성자(초기화)
//	public CouponDto(Coupon coupon) {
//		
//		this.couponType = coupon.getCouponType();
//		this.couponCode = coupon.getCouponCode();
//		this.couponDiscount = coupon.getCouponDiscount();
//		this.couponExpirationDate = coupon.getCouponExpirationDate();
//		this.couponIsUsed = coupon.getCouponIsUsed();
//		this.createdAt = coupon.getCreatedAt();
//		this.updatedAt =coupon.getUpdatedAt();
//		
//	}


}
