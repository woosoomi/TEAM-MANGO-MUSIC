
package com.itwill.jpa.controller.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.DeliveryService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {

	private final OrderService orderService;
	private final OrderItemService orderItemService;
	private final DeliveryService deliveryService;
	private final CouponService couponService;

	
	/* Restful Order */

	
	// 주문생성 (User(FK), Delivery(FK) 아직 null) -- 실패
	@Operation(summary = "주문생성[실패]")
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(orderDto));
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

	// 주문수정(관리자권한 orderPrice, orderStatus 수정가능) -- 성공
	@Operation(summary = "주문수정[성공]")
	@PutMapping("/update")
	public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto) throws Exception {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(orderService.updateOrder(orderDto));
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
			
	// 주문 1개 삭제 (파라미터가 orderId자체를 롱타입이 아닌 문자타입으로 가는거 같음) -- 실패
	@Operation(summary = "주문한개삭제[실패]")
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
	    try {
	        orderService.deleteOrder(orderId);
	        return ResponseEntity.status(HttpStatus.OK).body("주문번호" + orderId + "번이 삭제 되었습니다.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", e.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	}

	// 주문 전체 삭제 -- 성공
	@Operation(summary = "주문전체삭제[성공]")
	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllOrder() {
	    try {
	        orderService.deleteAllOrder();
	        return ResponseEntity.status(HttpStatus.OK).body("전체 주문이 삭제 되었습니다.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", e.getMessage());
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	    }
	}

	// 유저가 만든 주문 전체 불러오기(서비스에서는 잘만 주문리스트 불러오는데, 스웨거에서는 성공이지만 왜 주문리스트가 비어있는지..) -- 성공
	@Operation(summary = "로그인한 유저 주문내역 불러오기[성공]")
	@GetMapping("/{userId}")
	public ResponseEntity<?> getOrdersByUserId(@PathVariable String userId) {
		try {
			List<OrderDto> userOrders = orderService.ordersByUserId(userId);
			return ResponseEntity.status(HttpStatus.OK).body(userOrders);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}

	}

	// 전체 유저의 주문 전체 불러오기(관리자권한) -- 성공!
	@Operation(summary = "사이트 전체 주문 내역 불러오기(관리자)[성공]")
	@GetMapping("/all") 
	public ResponseEntity<?> getAllOrders() {
		try {
			List<OrderDto> orders = orderService.orders();
			return ResponseEntity.status(HttpStatus.OK).body(orders);
		} catch (Exception e) {
			e.printStackTrace();
			Map<String, String> errorResponse = new HashMap<>();
			errorResponse.put("error", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}

	
	/* Restful OrderItem */
	

	/* Restful Delivery */


	/* Restful Coupon */

}
