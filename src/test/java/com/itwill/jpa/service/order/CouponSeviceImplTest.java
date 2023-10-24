package com.itwill.jpa.service.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.jpa.TeamProjectMangoApplicationTest;

import jakarta.transaction.Transactional;

class CouponSeviceImplTest extends TeamProjectMangoApplicationTest{
	
	@Autowired
	CouponSeviceImpl couponSeviceImpl;
	
	@Test
	@Transactional
	@Rollback(false)
	//@Disabled
	void test() {
	}

}
