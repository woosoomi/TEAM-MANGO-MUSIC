package com.itwill.jpa.dto.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Ticket;

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

public class ProductGoodsDto {

	private String productName;  // 프로덕트 이름
	
	private int productPrice; // 프로덕트 가격
	
	private Long readCount; // 조회수
	
	private String productContent; // 프로덕트(음악,굿즈,티켓) 설명
		
	private int productStar; // 프로덕트(음악,굿즈,티켓) 별점
	
	private Date productDate; // 프로덕트(음악,굿즈,티켓) 등록날짜
	
	private int productStock; // 프로덕트(굿즈, 티켓) 재고
	
	private String productImage; // 프로덕트(음악,굿즈,티켓,멤버십) 이미지
	
	//Dto에서 보여주는 goods 정보가 무엇인지 설정하는 생성자(초기화)
	
	public ProductGoodsDto(Goods goods) {
		this.productName = goods.getProductName();
		this.productPrice = goods.getProductPrice();
		this.readCount = goods.getReadCount();
		this.productContent = goods.getProductContent();
		this.productStar = goods.getProductStar();
		this.productDate = goods.getProductDate();
		this.productStock = goods.getProductStock();
		this.productImage = goods.getProductImage();
	}
	//Entity to Dto 변환
	public static ProductGoodsDto toDto(Goods entity) {
		return ProductGoodsDto.builder()
				.productName(entity.getProductName())
				.productPrice(entity.getProductPrice())
				.readCount(entity.getReadCount())
				.productContent(entity.getProductContent())
				.productStar(entity.getProductStar())
				.productDate(entity.getProductDate())
				.productStock(entity.getProductStock())
				.productImage(entity.getProductImage())
				.build();
}
	//List<Entity> to List<Dto> 변환
	public static List<ProductGoodsDto> toDto(List<Goods> entities) {
		List<ProductGoodsDto> productGoodsDtoList = new ArrayList<>();
		 for(Goods entity : entities) {
			 ProductGoodsDto productGoodsDto = ProductGoodsDto.builder()
						.productName(entity.getProductName())
						.productPrice(entity.getProductPrice())
						.readCount(entity.getReadCount())
						.productContent(entity.getProductContent())
						.productStar(entity.getProductStar())
						.productDate(entity.getProductDate())
						.productStock(entity.getProductStock())
						.productImage(entity.getProductImage())
						.build();
			 productGoodsDtoList.add(productGoodsDto);
		 }
		 return productGoodsDtoList;
	}
	}
