package com.itwill.jpa.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.DeliveryService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrdersController {

	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private DeliveryService deliveryService;
	
	@Autowired
	private CouponService couponService;
	
	
	@GetMapping
	public String order_page() {
		return "order";
	}
	
	@GetMapping("/orderdetail")
	public String orderdetail_page() {
		return "orderdetail";
	}
	
}
