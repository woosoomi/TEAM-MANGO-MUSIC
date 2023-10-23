package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;

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
		Delivery findDelivery = deliveryRepository.findById(delivery.getDeliveryId()).get();
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
	public Delivery findDelivery(User user) {
		Long findUser = Long.parseLong(user.getUserId());
		return deliveryRepository.findById(findUser).get();
	}

	@Override
	public List<Delivery> deliverysFindById(User user) {
		// TODO Auto-generated method stub
		return null;
	}

//	// userId를 기준으로 해당 유저에 대한 모든 배송 정보를 조회
//	@Override
//	public List<Delivery> deliverysFindById(User user) {
//	    return deliveryRepository.findByUserId(user.getUserId());
//	}

}