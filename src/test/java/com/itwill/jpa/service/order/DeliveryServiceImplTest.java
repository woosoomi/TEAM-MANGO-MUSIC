package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;
import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dao.user.UserDao;
import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Coupon;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;

import jakarta.transaction.Transactional;

class DeliveryServiceImplTest extends TeamProjectMangoApplicationTest{

	@Autowired
	DeliveryServiceImpl deliveryServiceImpl;
	
	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	@Autowired
	UserDao userDao;
	
	//배송 생성 성공
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deliveryCreateTest() {
		Delivery delivery = new Delivery();
		User user = userDao.findUser("why3795");
		
		delivery.setUser(user);
		
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		
		deliveryDto.setDeliveryId(null);
		deliveryDto.setDeliveryCompany("대한통운");
		deliveryDto.setDeliveryName("고범석");
		deliveryDto.setDeliveryAddress("영월");
		deliveryDto.setDeliveryPhone("010-2000-3000");
		
		
		DeliveryDto createdDeliveryDto = deliveryServiceImpl.saveDelivery(deliveryDto);
		
		System.out.println(createdDeliveryDto);
		
	}

	//배송 수정 실패
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void deliveryUpdateTest() throws Exception{
		Delivery delivery = deliveryDao.findByDeliveryId(1L);
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);

		deliveryDto.setDeliveryId(null);
		deliveryDto.setDeliveryCompany("우체국");
		deliveryDto.setDeliveryName("개리");
		deliveryDto.setDeliveryAddress("서울");
		deliveryDto.setDeliveryPhone("010-2342-3463");
		
		DeliveryDto updatedDeliveryDto = deliveryServiceImpl.updateDelivery(deliveryDto);



		System.out.println(updatedDeliveryDto);

	}
	
	//배송 한개 삭제(성공)
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void deliveryDeleteTest() throws Exception {
		
		deliveryServiceImpl.deleteDelivery(2L);

	}
	
}
