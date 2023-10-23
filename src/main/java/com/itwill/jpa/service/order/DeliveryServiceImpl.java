package com.itwill.jpa.service.order;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.Order;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.order.OrderRepository;

import jakarta.transaction.Transactional;
@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	//배송지 정보 저장
	@Override
	public Delivery saveDelivery(Delivery delivery) {
		
		return deliveryRepository.save(delivery);
	}
	
	//배송지 정보 수정
	@Transactional
	@Override
	public Delivery updateDelivery(Delivery delivery) throws Exception{
	
		return deliveryDao.updateDelivery(delivery);
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
//
//	
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

////	// userId를 기준으로 해당 유저에 대한 모든 배송 정보를 조회
////	@Override
////	public List<Delivery> deliverysFindById(User user) {
////	    return deliveryRepository.findByUserId(user.getUserId());
////	}
	
	//배송지아이디로 배송지 정보 찾기
	@Override
	public Delivery findByDeliveryId(Long id) {
		return deliveryDao.findByDeliveryId(id);
	}

}
