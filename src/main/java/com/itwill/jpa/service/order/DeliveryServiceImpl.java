package com.itwill.jpa.service.order;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;

public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	//배송지 정보 저장
	@Override
	public Delivery saveDelivery(Delivery delivery) {
		
		return deliveryRepository.save(delivery);
	}
	
	//배송지 정보 수정
	@Transactional
	@Override
	public Delivery updateDelivery(Delivery delivery) {
		Delivery findDelivery = deliveryRepository.findById(delivery.getDeliveryNo()).get();
		findDelivery.setDeliveryName(delivery.getDeliveryName());
		findDelivery.setDeliveryCompany(delivery.getDeliveryCompany());
		findDelivery.setDeliveryName(delivery.getDeliveryName());
		findDelivery.setDeliveryAddress(delivery.getDeliveryAddress());
		findDelivery.setDeliveryPhone(delivery.getDeliveryPhone());
	
		return findDelivery;
	}

	//배송지 정보 삭제
	@Override
	public void deleteDelivery(Long id) throws Exception {
		deliveryRepository.deleteById(id);
		
	}

	//배송지 정보들 불러오기
	@Override
	public List<Delivery> deliverys() {
		return deliveryRepository.findAll();
	}

	
	//아이디로 배송지 정보 하나 불러오기
	@Override
	public Delivery findDelivery(Order order) {
		Long findUser = Long.parseLong(order.getUser().getUserId());
		return deliveryRepository.findById(findUser).get();
	}

	// userId를 기준으로 해당 유저에 대한 모든 배송 정보를 조회
	@Override
	public List<Delivery> deliverysFindById(Order order) {
	    return deliveryRepository.findByUserId(order.getUser().getUserId());
	}

}
