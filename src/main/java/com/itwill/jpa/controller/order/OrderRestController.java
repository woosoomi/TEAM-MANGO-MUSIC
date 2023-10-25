package com.itwill.jpa.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.service.order.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
	
    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/update")
    public Order updateOrder(@RequestBody Order order) throws Exception {
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/delete/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) throws Exception {
        orderService.deleteOrder(orderId);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllOrders() throws Exception {
        orderService.deleteAllOrder();
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable String userId) {
        return orderService.ordersByUserId(userId);
    }

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.orders();
    }
}
