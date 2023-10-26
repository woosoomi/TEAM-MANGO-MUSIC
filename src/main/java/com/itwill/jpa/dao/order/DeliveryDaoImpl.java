package com.itwill.jpa.dao.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.dto.order.DeliveryDto;
import com.itwill.jpa.dto.order.OrderItemDto;
import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.entity.order.OrderItem;
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
		Delivery savedDelivery = deliveryRepository.save(Delivery.toEntity(delivery));
		DeliveryDto deliveryDto = DeliveryDto.toDto(savedDelivery);
		return deliveryDto;
	}


	@Override
	public DeliveryDto updateDelivery(DeliveryDto updateDelivery) throws Exception{
		//Delivery가 존재하는지 확인
		Optional<Delivery> findDeliveryOptional = deliveryRepository.findById(updateDelivery.getDeliveryId());
		Delivery updatedDelivery = null;
		if(findDeliveryOptional.isPresent()) {
			//존재한다면 업데이트 실행
			Delivery delivery = findDeliveryOptional.get();
			delivery.setDeliveryName(updateDelivery.getDeliveryName());
			delivery.setDeliveryCompany(updateDelivery.getDeliveryCompany());
			delivery.setDeliveryAddress(updateDelivery.getDeliveryAddress());
			delivery.setDeliveryPhone(updateDelivery.getDeliveryPhone());
			//업데이트된 Delivery를 저장
			updatedDelivery = deliveryRepository.save(delivery);
		}else {
			throw new Exception("존재하지 않는 주소입니다.");
		}
		return DeliveryDto.toDto(updatedDelivery);
	}

	
	@Override
	public void deleteDelivery(Long deliveryId) throws Exception{
		//Delivery가 존재하는지 확인 -> 없으면 오류 메세지 던지기
		Optional<Delivery> deleteDeliveryOptional = deliveryRepository.findById(deliveryId);
		if(deleteDeliveryOptional.isEmpty()) {
			throw new Exception("삭제할 주소가 존재하지 않습니다.");
		}
		deliveryRepository.delete(deleteDeliveryOptional.get());
	}

	@Override
	public void selectList() {
		
		deliveryRepository.findAll();
	}

	@Override
	public DeliveryDto findByDeliveryId(Long id) {
		Delivery delivery = deliveryRepository.findById(id).get();
		DeliveryDto deliveryDto = DeliveryDto.toDto(delivery);
		return deliveryDto;
	}


	@Override
	public List<DeliveryDto> getDeliveriesByUserId(String userId) {
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

}
