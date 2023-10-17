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
public class OrderDto {

	private String userid;

	private List<OrderItemDto> orderItems;
	


}
