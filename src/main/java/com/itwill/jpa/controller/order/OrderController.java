package com.itwill.jpa.controller.order;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;

import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;
import com.itwill.jpa.service.product.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CouponService couponService;
	
	@GetMapping("/order_membership")
	public String orderMembershipPage(Model model, HttpServletRequest request) {
		
		try {
			
			
			/*************** 유저정보 ***************/
			
			
			//임의로 세션 로그인 유저 설정함
			HttpSession session = request.getSession();
			session.setAttribute("user_id", "lsg33");
			String userId = (String) session.getAttribute("user_id");
			model.addAttribute("user_id", userId);
			
			
			/*************** 주문아이템 ***************/
			
			
			//멤버쉽 카테고리번호 4 픽스
			Long categoryId = 4L;
			
			//로그인한 유저가 맞다면 오더페이지 아니면 로그인 페이지로 이동
			//로그인 체크가 생기면 아래 조건문 지울것
			if(userId != null) {
				
				//유저의 카테고리별 주문아이템 조회하기
				List<OrderItemDto> orderItemDtoList = orderService.findOrderItemsByUserIdAndProductCategoryId(userId, categoryId);
				//List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
				//model.addAttribute("orderDtoList", orderDtoList);
				//System.out.println("주문 아이템: " + orderDtoList);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				
				// Product 엔티티의 정보를 저장할 변수
	            Date membershipStartPeriod = null;
	            int membershipPeriodOfUse = 0;
	            String membershipName = null;
	            String membershipImage = null;
	            String membershipContent = null;
	            
	            // 주문 아이템별로 Product 정보 가져오기
	            for (OrderItemDto orderItemDto : orderItemDtoList) {
	                Long productNo = orderItemDto.getProductNo();
	                Product product = productService.getProduct(productNo);
	                if (product != null) {
	                    // Product 엔티티의 멤버십 시작일 정보 가져오기
	                    membershipStartPeriod = product.getStartPeriod();
	                    membershipPeriodOfUse = product.getPeriodOfUse();
	                    membershipName = product.getProductName();
	                    membershipImage = product.getProductImage();
	                    membershipContent = product.getProductContent();
	                }
	            }
	            model.addAttribute("membershipStartPeriod", membershipStartPeriod);
	            model.addAttribute("membershipPeriodOfUse", membershipPeriodOfUse);
	            model.addAttribute("membershipName", membershipName);
	            model.addAttribute("membershipImage", membershipImage);
	            model.addAttribute("membershipContent", membershipContent);
	            
	            
	            /*************** 가격 ***************/
	            
	            
	            double orderPrice = orderService.calculateTotalOrderPriceByCatagoryId(userId, categoryId);
	            //상품 가격 소수점 아래 절사
	            int formattedOrderPrice = (int) orderPrice;
	            model.addAttribute("orderPrice", orderPrice);
	            model.addAttribute("formattedOrderPrice", formattedOrderPrice);
	            
	            
	            /*************** 쿠폰 ***************/
	            
	            	            
	            // 유저의 쿠폰정보 불러오기
	            List<CouponDto> couponDtoList = couponService.couponsByUserId(userId);
	            model.addAttribute("couponDtoList", couponDtoList);	
	            for (CouponDto couponDto : couponDtoList) {
	                Double couponDiscount = couponDto.getCouponDiscount();
	                if (couponDiscount != null) {
	                    int discount = couponDiscount.intValue(); // Double 값을 int로 변환
	                    model.addAttribute("discount", discount);
	                } else {
	                    // 할인율이 null인 경우
	                }
	            }
	            //쿠폰 할인 적용 메서드
	            double salePrice = couponService.applyCouponDiscount(userId, formattedOrderPrice);
	            //총 결제금액 소수점 아래 절사
	            int endPrice = (int) salePrice;
	            model.addAttribute("salePrice", salePrice);
	            model.addAttribute("endPrice", endPrice);
	           
	            return "order_membership";
	            
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
	            
	
	
	
	@GetMapping("/order_ticket")
	public String orderTicketPage(Model model, HttpServletRequest request) {
		
		try {
			
			
			/*************** 유저정보 ***************/
			
			
			//임의로 세션 로그인 유저 설정함
			HttpSession session = request.getSession();
			session.setAttribute("user_id", "lsg33");
			String userId = (String) session.getAttribute("user_id");
			model.addAttribute("user_id", userId);
			
			
			/*************** 주문아이템 ***************/
			
			
			//티켓 카테고리번호 3 픽스
			Long categoryId = 3L;
			
			//로그인한 유저가 맞다면 오더페이지 아니면 로그인 페이지로 이동
			//로그인 체크가 생기면 아래 조건문 지울것
			if(userId != null) {
				
				//유저의 카테고리별 주문아이템 조회하기
				List<OrderItemDto> orderItemDtoList = orderService.findOrderItemsByUserIdAndProductCategoryId(userId, categoryId);
				model.addAttribute("orderItemDtoList", orderItemDtoList);
				//List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
				//model.addAttribute("orderDtoList", orderDtoList);
				//System.out.println("주문 아이템: " + orderDtoList);
				
				// Product 엔티티의 정보를 저장할 변수 초기화
	            String ticketName = null;
	            String ticketImage = null;
	            int ticketStar = 0;
	            String ticketContent = null;
	            String ticketAddress = null;
	            Date ticketDate = null;
	            String ticketArtist = null;
	            int ticketStock = 0;
	            
	            // 주문 아이템별로 Product 정보 가져오기
	            for (OrderItemDto orderItemDto : orderItemDtoList) {
	                Long productNo = orderItemDto.getProductNo();
	                Product product = productService.getProduct(productNo);
	                if (product != null) {
	                    // Product 엔티티의 멤버십 시작일 정보 가져오기
	                    ticketName = product.getProductName();
	                    ticketImage = product.getProductImage();
	                    ticketStar = product.getProductStar();
	                    ticketContent = product.getProductContent();
	                    ticketAddress = product.getProductAddress();
	                    ticketDate = product.getProductDate();
	                    ticketArtist = product.getProductArtist();
	                    ticketStock = product.getProductStock();
	                }
	            }
	            model.addAttribute("ticketName", ticketName);
	            model.addAttribute("ticketImage", ticketImage);
	            model.addAttribute("ticketStar", ticketStar);
	            model.addAttribute("ticketContent", ticketContent);
	            model.addAttribute("ticketAddress", ticketAddress);
	            model.addAttribute("ticketDate", ticketDate);
	            model.addAttribute("ticketArtist", ticketArtist);
	            model.addAttribute("ticketStock", ticketStock);
	            
	            
	            /*************** 가격 ***************/
	            
	            
	            double orderPrice = orderService.calculateTotalOrderPriceByCatagoryId(userId, categoryId);
	            //상품 가격 소수점 아래 절사
	            int formattedOrderPrice = (int) orderPrice;
	            model.addAttribute("orderPrice", orderPrice);
	            model.addAttribute("formattedOrderPrice", formattedOrderPrice);
	            
	            
	            /*************** 쿠폰 ***************/
	            
	            	            
	            // 유저의 쿠폰정보 불러오기
	            List<CouponDto> couponDtoList = couponService.couponsByUserId(userId);
	            model.addAttribute("couponDtoList", couponDtoList);
	            for (CouponDto couponDto : couponDtoList) {
	                Double couponDiscount = couponDto.getCouponDiscount();
	                if (couponDiscount != null) {
	                    int discount = couponDiscount.intValue(); // Double 값을 int로 변환
	                    model.addAttribute("discount", discount);
	                } else {
	                    // 할인율이 null인 경우
	                }
	            }
	            //쿠폰 할인 적용 메서드
	            double salePrice = couponService.applyCouponDiscount(userId, formattedOrderPrice);
	            //총 결제금액 소수점 아래 절사
	            int endPrice = (int) salePrice;
	            model.addAttribute("salePrice", salePrice);
	            model.addAttribute("endPrice", endPrice);
				return "order_ticket";
				
			} else {
				// 추후에 메인(index)페이지 대신에 로그인 페이지로 보낼예정
				return "index";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}
				
	
				
	
	
	@GetMapping("/order_history")
	public String orderHistoryPage(Model model, HttpServletRequest request) {
		try {
			
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "rgh66");
			String userId = (String) session.getAttribute("user_id");
//			//테스트용 코드
			List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
			model.addAttribute("orderDtoList", orderDtoList);
			System.out.println("주문 내역:" + orderDtoList);
			List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
			model.addAttribute("orderItemDtoList", orderItemDtoList);
			
			//원래 코드
			//orderdetail.html에 리스트명 orderDtoNewerList로 바꿈
			List<OrderDto> orderDtoNewerList = orderService.orderListByNewer(userId);
			model.addAttribute("orderDtoNewerList", orderDtoNewerList);
			System.out.println("주문 내역 최신순:" + orderDtoNewerList);
			Context context = new Context();
			context.setVariable("user_id", userId);
			
			// Thymeleaf 템플릿에 컨텍스트를 전달
			model.addAttribute("context", context);
			return "order_history";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문 내역이 없습니다.", e.getMessage());
			return "index";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
	            
			
	
	
			
			
			
			

	
			
			
				
	
	
