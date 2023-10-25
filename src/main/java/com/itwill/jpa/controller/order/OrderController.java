package com.itwill.jpa.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.jpa.service.order.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/order")
	public String order_page() {
		return "order";
	}
	@GetMapping("/orderdetail")
	public String orderdetail_page() {
		return "orderdetail";
	}
}
