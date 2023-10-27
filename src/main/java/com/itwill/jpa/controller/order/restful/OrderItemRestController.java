
package com.itwill.jpa.controller.order.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.service.order.OrderItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orderItem")
@RequiredArgsConstructor//생성자를 자동으로 생성하여 멤버필드(DI)주입 해주는 어노테이션
public class OrderItemRestController {

	
	private final OrderItemService orderItemService;
	
	
	/* Restful OrderItem */
	


}
