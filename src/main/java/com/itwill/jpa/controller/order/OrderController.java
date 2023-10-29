package com.itwill.jpa.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
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
	public String orderPage(Model model, HttpServletRequest request) {
		
		try {
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "wsm55");
			String userId = (String) session.getAttribute("user_id");
			
			//로그인한 유저가 맞다면 오더페이지 아니면 로그인 페이지로 이동
			//로그인 체크가 생기면 아래 조건문 지울것
			if(userId != null) {
				//orderdetail.html에 리스트명 orderItemDtoList로 바꿈
				List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				System.out.println("주문 아이템: " + orderItemDtoList);
				//이부분 위아래중 어떤 불러오기 서비스를 선택할지 논의가 필요
				//List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
				//model.addAttribute("orderDtoList", orderDtoList);
				//System.out.println("주문 아이템: " + orderDtoList);
				
				// Thymeleaf 컨텍스트에 user_id와 orderItemDtoList를 추가
	            Context context = new Context();
	            context.setVariable("user_id", userId);
	            context.setVariable("orderItemDtoList", orderItemDtoList);

	            // Thymeleaf 템플릿에 컨텍스트를 전달
	            model.addAttribute("context", context);
	            
				return "order";
			} else {
				//추후에 메인(index)페이지 대신에 로그인 페이지로 보낼예정
				return "index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}
			
			
	@GetMapping("/orderdetail")
	public String orderDetailPage(Model model, HttpServletRequest request) {
		try {
			
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "wsm55");
			String userId = (String) session.getAttribute("user_id");
			
//			//테스트용 코드
//			List<OrderDto> testOrderDtoList = orderService.orders();
//			model.addAttribute("orderDtoNewerList", testOrderDtoList);
//			System.out.println("주문 내역 최신순:" + testOrderDtoList);
			
			//원래 코드
			//orderdetail.html에 리스트명 orderDtoNewerList로 바꿈
			List<OrderDto> orderDtoNewerList = orderService.orderListByNewer(userId);
			model.addAttribute("orderDtoNewerList", orderDtoNewerList);
			System.out.println("주문 내역 최신순:" + orderDtoNewerList);
			return "orderdetail";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문 내역이 없습니다.", e.getMessage());
			return "index";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
			
			
			
			

	
			
			
				
	
	
