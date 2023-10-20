package com.itwill.jpa.dto.product;


import java.sql.Date;

import com.itwill.jpa.entity.product.Product.Music;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
	
	private Long productNo;
	
	private String productName;  // 프로덕트 이름
	
	private int productPrice; // 프로덕트 가격
	
	private Long readCount; // 조회수
	
	private String productContent; // 프로덕트(음악,굿즈,콘서트) 설명
	
	private String productReply; // 프로덕트(음악,굿즈,콘서트) 댓글
	
	private String productStar; // 프로덕트(음악,굿즈,콘서트) 별점
	
	private Date productDate; // 프로덕트(음악,굿즈,콘서트) 등록날짜
	
	private int productStock; // 프로덕트(굿즈, 티켓) 재고
	
	private String productMovie; // 음악 뮤직비디오

	private String productArtist; // 음악 아티스트
	
	private String productAddress; // 콘서트 장소
	
	private Date startPeriod; // 멤버십 시작날짜
	
	private int periodOfUse; // 멤버십 사용기간
	
	
	

}
