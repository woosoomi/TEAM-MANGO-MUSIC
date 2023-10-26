package com.itwill.jpa.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;

	
	@GetMapping("/order")
	public String order_page(Model model, HttpServletRequest request) {
//		try {
//			HttpSession session = request.getSession();
//			session.setAttribute("user_id", "why3795");
//			String userId = (String) session.getAttribute("user_id");
//			List<OrderItemDto> orderItemList = orderItemService.orderItems(userId);
//			 model.addAttribute("orderItemList", orderItemList);
//			System.out.println("주문 아이템: "+ orderItemList);
//			return "order";
//		}catch(Exception e){
//			e.printStackTrace();
//			model.addAttribute("errorMsg: "+ e.getMessage());
//			return "index";
//		}
	return "order";
	}

	@GetMapping("/orderdetail")
	public String orderdetail_page(Model model) {
//		try {
//			List<Order> orderList = orderService.orderListByNewer("why3795");
//			model.addAttribute(orderList);
//			System.out.println("주문내역:" + orderList);
//			return "orderdetail";
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("errorMsg: " + e.getMessage());
//			return "index";
//		}
		return "orderdetail";
	}
}
