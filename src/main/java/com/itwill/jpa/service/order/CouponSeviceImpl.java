package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.CouponDao;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.repository.order.CouponRepository;

import jakarta.transaction.Transactional;

@Service
public class CouponSeviceImpl implements CouponService{

	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	CouponDao couponDao;
	
	//쿠폰 생성
	@Override
	public Coupon saveCoupon(Coupon coupon) {
		return couponRepository.save(coupon);
	}
	//쿠폰 정보 수정
	@Transactional
	@Override
	public Coupon updateCoupon(Coupon coupon) throws Exception{
		return couponDao.updateCoupon(coupon);
	}
	//쿠폰 한개 삭제
	@Override
	public void deleteCoupon(Long couponId) throws Exception {
		couponRepository.deleteById(couponId);
	}
	//쿠폰 전체 삭제
	@Override
	public void deleteAllCoupons() throws Exception {
		couponRepository.deleteAll();
	}
	//유저의 쿠폰들 불러오기
	@Override
	public List<Coupon> couponsByUserId(String userId) {
		
		return couponDao.getCouponsByUserId(userId);
	}
	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기
	@Override
	public Coupon findCouponByOrderId(Long orderId) {
		return couponDao.getCouponByOrderId(orderId);
	}

}
