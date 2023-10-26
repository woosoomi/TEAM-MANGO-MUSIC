package com.itwill.jpa.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.service.order.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/")
	public String order_page() {
		return "order";
	}

	@GetMapping("/orderdetail")
	public String orderdetail_page(Model model) {
		try {
			List<Order> orderList = orderService.orderListByNewer("why3795");
			model.addAttribute(orderList);
			System.out.println("주문내역:" + orderList);
			return "orderdetail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("erroMsg: " + e.getMessage());
			return "index";
		}
	}
}
