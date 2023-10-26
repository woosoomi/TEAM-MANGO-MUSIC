package com.itwill.jpa.dao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.user.UserRepository;
@Repository
public class DeliveryDaoImpl implements DeliveryDao {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public DeliveryDto insertDelivery(DeliveryDto delivery) {
		DeliveryDto savedDelivery = deliveryRepository.save(delivery);
		return savedDelivery;
	}


	@Override
	public DeliveryDto updateDelivery(DeliveryDto updateDelivery) throws Exception{
		//Delivery가 존재하는지 확인
		Optional<DeliveryDto> findDeliveryOptional = deliveryRepository.findById(updateDelivery.getDeliveryId());
		DeliveryDto updatedDelivery = null;
		if(findDeliveryOptional.isPresent()) {
			//존재한다면 업데이트 실행
			DeliveryDto delivery = findDeliveryOptional.get();
			delivery.setDeliveryName(updateDelivery.getDeliveryName());
			delivery.setDeliveryCompany(updateDelivery.getDeliveryCompany());
			delivery.setDeliveryAddress(updateDelivery.getDeliveryAddress());
			delivery.setDeliveryPhone(updateDelivery.getDeliveryPhone());
			//업데이트된 Delivery를 저장
			updatedDelivery = deliveryRepository.save(delivery);
		}else {
			throw new Exception("존재하지 않는 주소입니다.");
		}
		return updatedDelivery;
	}

	
	@Override
	public void deleteDelivery(Long deliveryId) throws Exception{
		//Delivery가 존재하는지 확인 -> 없으면 오류 메세지 던지기
		Optional<DeliveryDto> deleteDeliveryOptional = deliveryRepository.findById(deliveryId);
		if(deleteDeliveryOptional.isEmpty()) {
			throw new Exception("삭제할 주소가 존재하지 않습니다.");
		}
		deliveryRepository.delete(deleteDeliveryOptional.get());
	}

	@Override
	public List<DeliveryDto> selectList() {
		
		return deliveryRepository.findAll();
	}

	@Override
	public DeliveryDto findByDeliveryId(Long id) {
		DeliveryDto delivery = deliveryRepository.findById(id).get();
		return delivery;
	}


	@Override
	public List<DeliveryDto> getDeliveriesByUserId(String userId) {
		Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return deliveryRepository.findByUser(user);
        } else {
            return new ArrayList<>(); // 사용자를 찾지 못한 경우 빈 목록을 반환
        }
	}

}
