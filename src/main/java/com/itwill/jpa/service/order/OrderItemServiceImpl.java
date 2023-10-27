package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.OrderItemDao;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.repository.order.OrderItemRepository;
import com.itwill.jpa.repository.order.OrderRepository;
import com.itwill.jpa.repository.user.UserRepository;
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderItemDao orderItemDao;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserRepository userRepository;

	//아이템 추가
	@Override
	public OrderItemDto saveOrderItem(OrderItemDto dto) {
		
		OrderItem order = orderItemRepository.save(OrderItem.toEntity(dto));
		OrderItemDto orderItemDto = OrderItemDto.toDto(order);
		return orderItemDto;
	
	}

	//아이템 업데이트
	@Override
	public OrderItemDto updateOrderItem(OrderItemDto dto) {
	  OrderItem orderItem = orderItemDao.updateOrderItem(OrderItem.toEntity(dto));
	  OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
	    return orderItemDto;
	}
	
	//아이템아이디 받아와서 삭제하고 Dto에 삭제 주문 정보 저장
	@Override
	public OrderItemDto deleteOrderItem(Long oiId) throws Exception {
		OrderItem orderItem = orderItemRepository.findById(oiId).orElseThrow(() -> new IllegalArgumentException("주문아이템이 존재하지 않습니다."));
		orderItemRepository.deleteById(oiId);
		OrderItemDto orderItemDto = OrderItemDto.toDto(orderItem);
		return orderItemDto;
	}
	
	//유저 아이디 아이템 모두 삭제하고 Dto에 삭제 주문 정보 저장
	@Override
	public List<OrderItemDto> deleteAllOrderItem() throws Exception {
		List<OrderItem> orderItemList = orderItemRepository.findAll();
		List<OrderItemDto> orderItemDtoList = new ArrayList<OrderItemDto>();
		for (OrderItem orderItem : orderItemList) {
			orderItemDtoList.add(OrderItemDto.toDto(orderItem));
		}
		orderRepository.deleteAll();
		return orderItemDtoList;
		
	}

	//아이템 아이디로 아이템 선택하기
	@Override
	public OrderItemDto findOrderItem(Long oiId) {
		OrderItem selectedOrderItem = orderItemRepository.findById(oiId).get();
		OrderItemDto orderItemDto  = OrderItemDto.toDto(selectedOrderItem);
		return orderItemDto;
	}

	//오더 아이디를 받아와서 아이템리스트 나열
	@Override
	public List<OrderItemDto> orderItemsByOrderId(Long orderId) {
		List<OrderItem> orderItemList = orderItemDao.orderItems(orderId);
		List<OrderItemDto> orderItemDtoList = new ArrayList<OrderItemDto>();
		for (OrderItem orderItem : orderItemList) {
			orderItemDtoList.add(OrderItemDto.toDto(orderItem));
		}
		return orderItemDtoList;
	}

	// 유저 아이디로 주문아이템 전체 불러오기
	@Override
	public List<OrderItemDto> orderItemsByUserId(String userId) {
		return null;
		
//		List<OrderItem> orderItemList = orderItemRepository.findByUserId(userId);
//		List<OrderItemDto> orderItemDtoList = new ArrayList<OrderItemDto>();
//		for (OrderItem orderItem : orderItemList) {
//			orderItemDtoList.add(OrderItemDto.toDto(orderItem));
//		}
//		return orderItemDtoList;

	}

}
	

	
