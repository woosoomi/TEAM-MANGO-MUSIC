
package com.itwill.jpa.controller.order.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.service.order.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor//생성자를 자동으로 생성하여 멤버필드(DI)주입 해주는 어노테이션
public class CouponRestController {

	private final CouponService couponService;

	
	/* Restful Coupon */
	
	
}
