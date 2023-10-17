package com.itwill.jpa.dto.order;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//웹에서 고객에게 보여주기 위한 정보를 담은 객체
public class OrderDto {

	private String userid; //FK 주문자의 정보를 가져오기(이름, 전번, 주소등)

	private List<OrderItemDto> orderItems; //주문한 아이템 정보들(수량, 가격등)
	
	
	public String getOrderUserName() {
		
		String userName = "";
		
		return userName;
	}

	public String getOrderUserPhone() {
		
		String userPhone = "";
		
		return userPhone;
	}
}
