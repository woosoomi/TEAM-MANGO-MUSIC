package com.itwill.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OrderDto {

	private String ordername;
	
	private String orderaddress;
	
	private Long orderprice;	
	
}
