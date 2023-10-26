package com.itwill.jpa.service.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.repository.order.DeliveryRepository;

import jakarta.transaction.Transactional;
@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	//배송지 정보 저장
	@Override
	public DeliveryDto saveDelivery(DeliveryDto delivery) {
		
		return deliveryRepository.save(delivery);
	}
	
	//배송지 정보 수정
	@Transactional
	@Override
	public DeliveryDto updateDelivery(DeliveryDto delivery) throws Exception{
	
		return deliveryDao.updateDelivery(delivery);
	}

	//배송지 정보 삭제
	@Override
	public void deleteDelivery(Long id) throws Exception {
		deliveryRepository.deleteById(id);
		
	}

	//배송지 정보들 불러오기
	@Override
	public List<DeliveryDto> deliverys() {
		return deliveryRepository.findAll();
	}

	
	//아이디로 배송지 정보 불러오기
	@Override
	public List<DeliveryDto> findDelivery(String userId) {
		return deliveryDao.getDeliveriesByUserId(userId);
	}


	//배송지아이디로 배송지 정보 찾기
	@Override
	public DeliveryDto findByDeliveryId(Long id) {
		return deliveryDao.findByDeliveryId(id);
	}

}