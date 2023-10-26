package com.itwill.jpa.service.order;

import java.util.List;

import com.itwill.jpa.entity.order.Coupon;

public interface CouponService {
	
	//쿠폰생성
	Coupon saveCoupon(Coupon coupon);
	//쿠폰수정(관리자)
	Coupon updateCoupon(Coupon coupon) throws Exception;
	//쿠폰 삭제
	void deleteCoupon(Long couponId) throws Exception;
	//쿠폰 전체 삭제
	void deleteAllCoupons() throws Exception;
	//유저의 쿠폰들 불러오기
	List<Coupon> couponsByUserId(String userId);
	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기
	Coupon findCouponByOrderId(Long orderId);
	
}
