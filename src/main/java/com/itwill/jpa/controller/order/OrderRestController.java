package com.itwill.jpa.controller.order;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.service.order.CouponService;
import com.itwill.jpa.service.order.DeliveryService;
import com.itwill.jpa.service.order.OrderItemService;
import com.itwill.jpa.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderRestController {
	
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final DeliveryService deliveryService;
    private final CouponService couponService;
    
    
    //Restful Order
    
    //주문생성
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
    
    //주문수정(관리자권한)
    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) throws Exception {
        return orderService.updateOrder(order);
    }

    //주문번호로 주문 1개 삭제
    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) throws Exception {
        orderService.deleteOrder(orderId);
    }

    //주문 전체 삭제
    @DeleteMapping("/delete/all")
    public void deleteAllOrders() throws Exception {
        orderService.deleteAllOrder();
    }

    //유저가 만든 주문 전체 불러오기
    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        return orderService.ordersByUserId(userId);
    }
    
    //전체 유저의 주문 전체 불러오기(관리자권한)
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.orders();
    }
    
  //Restful OrderItem
   
  //주문 아이템 생성
  @PostMapping
  public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
	  return orderItemService.saveOrderItem(orderItem);
  }
    
  //Restful Delivery
  //Restful Coupon  
    
    
    
    
}
