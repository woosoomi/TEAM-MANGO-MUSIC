package com.itwill.jpa.dao.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.repository.order.DeliveryRepository;

public class DeliveryDaoImpl implements DeliveryDao {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Override
	public Delivery insertDelivery(Delivery delivery) {
		Delivery savedDelivery = deliveryRepository.save(delivery);
		return savedDelivery;
	}

	@Override
	public Delivery selectDelivery(Long deliveryNo){
		Delivery selectDelivery = deliveryRepository.findById(deliveryNo).get();
		return selectDelivery;
	}

	@Override
	public Delivery updateDelivery(Delivery updateDelivery) throws Exception{
		//Delivery가 존재하는지 확인
		Optional<Delivery> findDeliveryOptional = deliveryRepository.findById(updateDelivery.getDeliveryNo());
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
		return updatedDelivery;
	}

	@Override
	public void deleteDelivery(Long deliveryNo) throws Exception{
		//Delivery가 존재하는지 확인 -> 없으면 오류 메세지 던지기
		Optional<Delivery> deleteDeliveryOptional = deliveryRepository.findById(deliveryNo);
		if(deleteDeliveryOptional.isEmpty()) {
			throw new Exception("삭제할 주소가 존재하지 않습니다.");
		}
		deliveryRepository.delete(deleteDeliveryOptional.get());
	}

	@Override
	public List<Delivery> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

}
