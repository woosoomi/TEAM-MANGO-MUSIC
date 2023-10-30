package com.itwill.jpa.repository.product;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.product.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//    Product insertProduct(Product product);

//    Product findById(Long productNo);
    
	List<Product> findAll();
// productNo로 찾기
	Optional<Product> findById(Long productNo);
	
// productNo로 찾기[DTO]	
	@Query("SELECT p FROM Product p WHERE p.productNo = :productNo")
	Optional<ProductDto> findByIdDto(@Param("productNo") Long productNo);
	
	ProductDto save(ProductDto productDto);
	
	/******************** categoryId별로 전체나열 ********************/	
//	category로 찾기
	@Query("SELECT p FROM Product p WHERE p.productCategory.id = :categoryId")
	List<Product> findByProductCategoryId(@Param("categoryId") Long categoryId);
	
	List<Product> findByProductCategory(ProductCategory category);	
	List<Goods> findGoodsByProductCategory(ProductCategory category);	
	List<Ticket> findTicketByProductCategory(ProductCategory category);
	/*****************************************************************/
//	keyword가 포함된 product 찾기
	List<Product> findByProductNameContaining(String keyword);

//	productName로 찾기
//	Product findByProductName(String productName);
	
//	productArtist로 찾기
//	Product findByProductArtist(String productArtist);

	
    
}
