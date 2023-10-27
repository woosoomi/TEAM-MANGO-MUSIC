package com.itwill.jpa.dto.product;

import com.itwill.jpa.entity.product.ProductCategory;

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
public class ProductCategoryDto {
	 private String productCategoryName;
	 private Long categoryId;
	 
		// ProductDto에서 ProductCategoryDto를 쓰기위한 메서드
		// (ProductCategory entity를 건들지 않기위해 ProductDtoDto를 대신해서 사용 = 데이터 무결성 유지 목적)
	 public static ProductCategoryDto fromProductCategory(ProductCategory productCategory) {
		 
		 ProductCategoryDto productCategoryDto = new ProductCategoryDto();
		 productCategoryDto.setCategoryId(productCategory.getCategoryId());
		 productCategoryDto.setProductCategoryName(productCategory.getProductCategoryName());
		 return productCategoryDto;
	 }
	 
	 public static ProductCategoryDto toDto(ProductCategory productCategory) {
		 return ProductCategoryDto.builder()				 
				 .productCategoryName(productCategory.getProductCategoryName())
				 .categoryId(productCategory.getCategoryId())
				 .build();
	 }
}
