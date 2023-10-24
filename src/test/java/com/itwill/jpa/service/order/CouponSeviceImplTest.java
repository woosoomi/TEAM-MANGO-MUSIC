package com.itwill.jpa.service.order;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.OrderDao;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.CouponRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;
import com.itwill.jpa.service.user.UserServiceImpl;

import jakarta.transaction.Transactional;

class CouponSeviceImplTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	CouponSeviceImpl couponSeviceImpl;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Autowired
	CouponRepository couponRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	
	//쿠폰 생성(진행중)
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void couponCreateTest() {
		Coupon coupon = new Coupon();
		User user = userDao.findUser("팀장님");
		Order order = orderDao.selectOrder(2L);
		
		coupon.setCouponCode("00000033");
		coupon.setCouponId(null);
		coupon.setCouponDiscount(50.0);
		coupon.setCouponExpirationDate(null);
		coupon.setCouponIsUsed(0);
		coupon.setCouponName("테스트쿠폰");
		coupon.setCouponType("100년쿠폰");
		
		userRepository.save(user);
		orderRepository.save(order);
		
		Coupon createdCoupon = couponSeviceImpl.saveCoupon(coupon);
		System.out.println(createdCoupon);
		
		
	}
	
	//쿠폰 정보 수정(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponUpdateTest() throws Exception {

		Coupon coupon = couponRepository.findById(1L).get();
		coupon.setCouponCode("33333333");
		coupon.setCouponDiscount(30.0);
		coupon.setCouponExpirationDate(null);
		coupon.setCouponIsUsed(1);
		coupon.setCouponName("날이면 날마다 오는 쿠폰");
		coupon.setCouponType("12개월쿠폰");
		Coupon updatedCoupon = couponSeviceImpl.updateCoupon(coupon);
		System.out.println(updatedCoupon);
	
	}

	//쿠폰 한개 삭제(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponDeleteTest() throws Exception {
		
		couponSeviceImpl.deleteCoupon(1L);

	}

	//쿠폰 전체 삭제(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponDeleteAllTest() throws Exception {
		
		couponSeviceImpl.deleteAllCoupons();

	}
	
	//유저 아이디로 주문 전체 불러오기(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void couponByUserIdTest(){
		
		List<Coupon> couponList = couponSeviceImpl.couponsByUserId("팀장님");
		System.out.println(couponList);

	}

	//주문내역에서 해당 주문에 사용된 쿠폰 불러오기(성공)
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void findCouponByOrderIdTest(){
		
		Coupon coupon = couponSeviceImpl.findCouponByOrderId(3L);
		System.out.println(coupon);
	}
}