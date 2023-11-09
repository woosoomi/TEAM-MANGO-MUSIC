package com.itwill.jpa.controller.order;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.itwill.jpa.controller.user.LoginCheck;
import com.itwill.jpa.dto.order.CouponDto;
import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.user.UserService;

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
	
	@Autowired
	private UserService userService;

	
	@LoginCheck
	@GetMapping("/order_membership")
	public String orderMembershipPage(Model model, HttpSession session) {
		
		try {
			/*************** 유저정보 ***************/
			
			String userId = (String) session.getAttribute("sUserId");
			
			/*************** 주문아이템 ***************/

			// 멤버쉽 카테고리번호 4 픽스
			Long categoryId = 4L;
				
			//유저의 카테고리별 주문아이템 조회하기
			List<OrderItemDto> orderItemDtoList = orderService.findOrderItemsByUserIdAndProductCategoryId(userId, categoryId);
			model.addAttribute("orderItemDtoList", orderItemDtoList);
			
			// Product 엔티티의 정보를 저장할 변수
            Date membershipStartPeriod = null;
            int membershipPeriodOfUse = 0;
            String membershipName = null;
            String membershipImage = null;
            String membershipContent = null;
            Long membershipNo = 0L;
            
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
                    membershipNo = product.getProductNo();
                }
            }
            
            model.addAttribute("membershipStartPeriod", membershipStartPeriod);
            model.addAttribute("membershipPeriodOfUse", membershipPeriodOfUse);
            model.addAttribute("membershipName", membershipName);
            model.addAttribute("membershipImage", membershipImage);
            model.addAttribute("membershipContent", membershipContent);
            model.addAttribute("membershipNo", membershipNo);
                
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
	            			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}
	            
	
	
	@LoginCheck
	@GetMapping("/order_ticket")
	public String orderTicketPage(Model model, HttpSession session) {
		
		try {
			/*************** 유저정보 ***************/
			
			String userId = (String) session.getAttribute("sUserId");
			
			/*************** 주문아이템 ***************/
			
			//티켓 카테고리번호 3 픽스
			Long categoryId = 3L;
						
			//유저의 카테고리별 주문아이템 조회하기
			List<OrderItemDto> orderItemDtoList = orderService.findOrderItemsByUserIdAndProductCategoryId(userId, categoryId);

			model.addAttribute("orderItemDtoList", orderItemDtoList);

			// Product 엔티티의 정보를 저장할 변수
			Date membershipStartPeriod = null;
			int membershipPeriodOfUse = 0;
			String membershipName = null;
			String membershipImage = null;
			String membershipContent = null;
			Long membershipNo = 0L;

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
					membershipNo = product.getProductNo();
				}
			}
			
			model.addAttribute("membershipStartPeriod", membershipStartPeriod);
			model.addAttribute("membershipPeriodOfUse", membershipPeriodOfUse);
			model.addAttribute("membershipName", membershipName);
			model.addAttribute("membershipImage", membershipImage);
			model.addAttribute("membershipContent", membershipContent);
			model.addAttribute("membershipNo", membershipNo);

			/*************** 가격 ***************/

			double orderPrice = orderService.calculateTotalOrderPriceByCatagoryId(userId, categoryId);
			// 상품 가격 소수점 아래 절사
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
			// 쿠폰 할인 적용 메서드
			double salePrice = couponService.applyCouponDiscount(userId, formattedOrderPrice);
			// 총 결제금액 소수점 아래 절사
			int endPrice = (int) salePrice;
			model.addAttribute("salePrice", salePrice);
			model.addAttribute("endPrice", endPrice);

			return "order_ticket";


		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문이 존재하지 않습니다.", e.getMessage());
			return "index";
		}
	}

				
	
				
	
	@LoginCheck
	@GetMapping("/order_history")
	public String orderHistoryPage(Model model, HttpSession session) {
		try {

			
			String userId = (String) session.getAttribute("sUserId");
			UserDto user = userService.findUser(userId);
			model.addAttribute("user", user);
			//테스트용 코드

			List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
			model.addAttribute("orderDtoList", orderDtoList);
			System.out.println("주문 내역:" + orderDtoList);
			List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
			model.addAttribute("orderItemDtoList", orderItemDtoList);

			System.out.println("orderItemDtoList:"+ orderItemDtoList);
			//원래 코드
			//orderdetail.html에 리스트명 orderDtoNewerList로 바꿈

			List<OrderDto> orderDtoNewerList = orderService.orderListByNewer(userId);


			model.addAttribute("orderDtoNewerList", orderDtoNewerList);
			System.out.println("주문 내역 최신순:" + orderDtoNewerList);
			

			return "order_history";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문 내역이 없습니다.", e.getMessage());
			return "index";
		}
	}

	
	
	
	@GetMapping("/order_history_copy")
	public String order_history_copy(Model model, HttpServletRequest request) {
		try {
			
			HttpSession session = request.getSession();
			//일단 임의로 세션 로그인 유저 설정함
			session.setAttribute("user_id", "cgj22");
			String userId = (String) session.getAttribute("user_id");
			
			//주문 DTO 가져오기
			List<OrderDto> orderDtoList = orderService.ordersByUserId(userId);
			model.addAttribute("orderDtoList", orderDtoList);
			
			
			
			//주문 아이템 DTO 가져오기
			List<OrderItemDto> orderItemDtoList = orderItemService.orderItemsByUserId(userId);
			model.addAttribute("orderItemDtoList", orderItemDtoList);
			
			
			
			//원래 코드
			return "order_history_copy";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("주문 내역이 없습니다.", e.getMessage());
			return "index";
		}
	}
	
	
	
	
	
	
	
	
	
}
	            
			
	
	
			
			
			
			



