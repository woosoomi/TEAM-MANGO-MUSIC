package com.itwill.jpa.service.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.jpa.dao.order.DeliveryDao;
import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.transaction.Transactional;
@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	DeliveryDao deliveryDao;
	
	@Autowired
	UserRepository userRepository;
	
	//배송지 정보 저장
	@Override
	public DeliveryDto saveDelivery(DeliveryDto dto) {
		
		Delivery delivery = deliveryRepository.save(Delivery.toEntity(dto));
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		
		return deliveryDto;
	}
	
	//배송지 정보 수정
	@Transactional
	@Override
	public DeliveryDto updateDelivery(DeliveryDto delivery) throws Exception{
		Delivery updateDelivery = deliveryDao.updateDelivery(Delivery.toEntity(delivery));
		DeliveryDto updateDeliveryDto = DeliveryDto.toDto(updateDelivery);
		return updateDeliveryDto;
	}

	//배송지 정보 삭제
	@Override
	public void deleteDelivery(Long id) throws Exception {
		deliveryRepository.deleteById(id);
		
	}

	//배송지 정보들 불러오기
	@Override
	public void deliverys() {
		deliveryDao.selectList();;
	}

	
	//아이디로 배송지 정보 불러오기
	@Override
	public List<DeliveryDto> findDelivery(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            List<Delivery> deliveryItems = deliveryRepository.findByUser(user);
            List<DeliveryDto> deliveryItemDtos = new ArrayList<>();
            for (Delivery deliveryItem : deliveryItems) {
            	DeliveryDto deliveryItemDto = DeliveryDto.toDto(deliveryItem);
            	deliveryItemDtos.add(deliveryItemDto);
        	}
        	return deliveryItemDtos;
        } else {
            return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
        }
	
	}


	//배송지아이디로 배송지 정보 찾기
	@Override
	public DeliveryDto findByDeliveryId(Long id) {
		Delivery delivery = deliveryRepository.findById(id).get();
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		return deliveryDto;
	}

}