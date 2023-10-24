package com.itwill.jpa.entity.product;

import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.product.ProductCategoryDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "product_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {
   
 @Id 
 @Column(name = "category_id")
 @SequenceGenerator(name = "PRODUCT_CATEGORY_NO_SEQ",sequenceName = "PRODUCT_CATEGORY_NO_SEQ",initialValue = 1 , allocationSize =1)
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_CATEGORY_NO_SEQ")
 private Long categoryId;
 private String productCategoryName;
 
 public static ProductCategory toEntity(ProductCategoryDto dto) {
	 return ProductCategory.builder()
			 			   .productCategoryName(dto.getProductCategoryName())
			 			   .build();
 }
 
 //productcategory와 product -> 1:n관계
	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<Product> products = new ArrayList<Product>();
}