package com.itwill.jpa.service.order;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.jpa.entity.order.Delivery;
import com.itwill.jpa.repository.order.DeliveryRepository;
import com.itwill.jpa.repository.user.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@ExtendWith(MockitoExtension.class)
class DeliveryServiceTest {

	@InjectMocks
	DeliveryService deliveryService;
	@Mock
	DeliveryRepository deliveryRepository;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	void insert() {
		Delivery delivery = new Delivery();
		delivery.setDeliveryAddress("서울시");
		delivery.setDeliveryCompany("롯데");
		delivery.setDeliveryId(null);
		delivery.setDeliveryName("집");
		delivery.setDeliveryPhone("1234");
		
		deliveryService.saveDelivery(delivery);
		
		
		
	}

}
