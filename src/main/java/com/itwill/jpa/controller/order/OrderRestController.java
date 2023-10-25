/*
 * package com.itwill.jpa.controller.order;
 * 
 * import java.util.List;
 * 
 * import org.springframework.web.bind.annotation.DeleteMapping; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.itwill.jpa.entity.order.Coupon; import
 * com.itwill.jpa.entity.order.Delivery; import
 * com.itwill.jpa.entity.order.Order; import
 * com.itwill.jpa.entity.order.OrderItem; import
 * com.itwill.jpa.service.order.CouponService; import
 * com.itwill.jpa.service.order.DeliveryService; import
 * com.itwill.jpa.service.order.OrderItemService; import
 * com.itwill.jpa.service.order.OrderService;
 * 
 * import lombok.RequiredArgsConstructor;
 * 
 * @RestController
 * 
 * @RequestMapping("/order")
 * 
 * @RequiredArgsConstructor public class OrderRestController {
 * 
 * private final OrderService orderService; private final OrderItemService
 * orderItemService; private final DeliveryService deliveryService; private
 * final CouponService couponService;
 * 
 * Restful Order
 * 
 * // 주문생성
 * 
 * @PostMapping("/create") public Order createOrder(@RequestBody Order order) {
 * return orderService.saveOrder(order); }
 * 
 * // 주문수정(관리자권한)
 * 
 * @PutMapping("/update") public Order updateOrder(@RequestBody Order order)
 * throws Exception { return orderService.updateOrder(order); }
 * 
 * // 주문번호로 주문 1개 삭제
 * 
 * @DeleteMapping("/delete/{orderId}") public void deleteOrder(@PathVariable
 * Long orderId) throws Exception { orderService.deleteOrder(orderId); }
 * 
 * // 주문 전체 삭제
 * 
 * @DeleteMapping("/delete/all") public void deleteAllOrders() throws Exception
 * { orderService.deleteAllOrder(); }
 * 
 * // 유저가 만든 주문 전체 불러오기
 * 
 * @GetMapping("/user/{userId}") public List<Order>
 * getOrdersByUserId(@PathVariable String userId) { return
 * orderService.ordersByUserId(userId); }
 * 
 * // 전체 유저의 주문 전체 불러오기(관리자권한)
 * 
 * @GetMapping("/all") public List<Order> getAllOrders() { return
 * orderService.orders(); }
 * 
 * Restful OrderItem
 * 
 * // 아이템 추가
 * 
 * @PostMapping public OrderItem createOrderItem(@RequestBody OrderItem
 * orderItem) { return orderItemService.saveOrderItem(orderItem); }
 * 
 * // 아이템 업데이트
 * 
 * @PutMapping("/update") public OrderItem updateOrderItem(@RequestBody
 * OrderItem orderItem) { return orderItemService.updateOrderItem(orderItem); }
 * 
 * // 아이템아이디 받아와서 삭제
 * 
 * @DeleteMapping("/delete/{id}") public void deleteOrderItem(@PathVariable Long
 * id) throws Exception { orderItemService.deleteOrderItem(id); }
 * 
 * // 유저 아이디 아이템 모두 삭제
 * 
 * @DeleteMapping("/delete/all") public void deleteAllOrderItems() throws
 * Exception { orderItemService.deleteAllOrderItem(); }
 * 
 * // 아이템 아이디로 아이템 선택하기
 * 
 * @GetMapping("/order/{orderId}") public List<OrderItem>
 * getOrderItemsByOrderId(@PathVariable Long orderId) { return
 * orderItemService.orderItems(orderId); }
 * 
 * // 오더 아이디를 받아와서 아이템리스트 나열
 * 
 * @GetMapping("/{id}") public OrderItem getOrderItem(@PathVariable Long id) {
 * return orderItemService.findOrderItem(id); }
 * 
 * Restful Delivery
 * 
 * // 배송지 정보 저장
 * 
 * @PostMapping("/create") public Delivery createDelivery(@RequestBody Delivery
 * delivery) { return deliveryService.saveDelivery(delivery); }
 * 
 * // 배송지 정보 수정
 * 
 * @PutMapping("/update") public Delivery updateDelivery(@RequestBody Delivery
 * delivery) throws Exception { return deliveryService.updateDelivery(delivery);
 * }
 * 
 * // 배송지 정보 삭제
 * 
 * @DeleteMapping("/delete/{id}") public void deleteDelivery(@PathVariable Long
 * id) throws Exception { deliveryService.deleteDelivery(id); }
 * 
 * // 배송지 정보들 불러오기
 * 
 * @GetMapping("/all") public List<Delivery> getAllDeliveries() { return
 * deliveryService.deliverys(); }
 * 
 * // 아이디로 배송지 정보 불러오기
 * 
 * @GetMapping("/user/{userId}") public List<Delivery>
 * getDeliveriesByUserId(@PathVariable String userId) { return
 * deliveryService.findDelivery(userId); }
 * 
 * // 배송지아이디로 배송지 정보 찾기
 * 
 * @GetMapping("/{id}") public Delivery getDeliveryById(@PathVariable Long id) {
 * return deliveryService.findByDeliveryId(id); }
 * 
 * Restful Coupon
 * 
 * // 쿠폰생성
 * 
 * @PostMapping("/create") public Coupon createCoupon(@RequestBody Coupon
 * coupon) { return couponService.saveCoupon(coupon); }
 * 
 * // 쿠폰수정(관리자)
 * 
 * @PutMapping("/update") public Coupon updateCoupon(@RequestBody Coupon coupon)
 * throws Exception { return couponService.updateCoupon(coupon); }
 * 
 * // 쿠폰 삭제
 * 
 * @DeleteMapping("/delete/{couponId}") public void deleteCoupon(@PathVariable
 * Long couponId) throws Exception { couponService.deleteCoupon(couponId); }
 * 
 * // 쿠폰 전체 삭제
 * 
 * @DeleteMapping("/delete/all") public void deleteAllCoupons() throws Exception
 * { couponService.deleteAllCoupons(); }
 * 
 * // 유저의 쿠폰들 불러오기
 * 
 * @GetMapping("/user/{userId}") public List<Coupon>
 * getCouponsByUserId(@PathVariable String userId) { return
 * couponService.couponsByUserId(userId); }
 * 
 * // 주문내역에서 해당 주문에 사용된 쿠폰 불러오기
 * 
 * @GetMapping("/order/{orderId}") public Coupon
 * getCouponByOrderId(@PathVariable Long orderId) { return
 * couponService.findCouponByOrderId(orderId); }
 * 
 * }
 */