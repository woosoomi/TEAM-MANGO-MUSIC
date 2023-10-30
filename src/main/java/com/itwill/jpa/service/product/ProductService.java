package com.itwill.jpa.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;



@Service
@Transactional(readOnly = true)
//@RequiredArgsConstructor
public interface ProductService{
	
	@Transactional
//Product//	
	Product getProduct(Long productNo); 

	List<Product> productList(); 
	
	List<Product> getProductsByCategory(Long categoryId);
	
	
	// 좋아요 누르기 기능[성공]
	Long checkLikeService(Long productNo);

	// 품절 안내 기능[성공]
	Product outOfStockMsg(Long productNo);

	/******************** INSERT ********************/
	// product 등록[성공]
	public Product insertProduct(Product product);	
	
	// music 등록[성공]
	public Music insertMusic(Music music);
	
	// goods 등록[성공]
	public Goods insertGoods(Goods goods);
	
	// goods 등록 - DTO
	GoodsDto insertGoodsDto(GoodsDto goodsDto);
	
	// ticket 등록[성공]
	public Ticket insertTicket(Ticket ticket);
	
	// ticket 등록 - DTO	
	TicketDto insertTicketDto(TicketDto ticketDto);
	
	// membership 등록[성공]
	public Membership insertMembership(Membership membership);
	/*********************************************/

	/******************** DELETE ********************/
	// product 삭제[성공]		
	void deleteProduct(Long productNo) throws Exception;
	
	// product 삭제 - DTO[성공]
	ProductDto deledtProductDto(Long productNo) throws Exception;
	
	// product 삭제[성공]
	public void deleteProduct2(Long productNo);
	/*********************************************/
	
	/******************** UPDATE ********************/	
	// product 업데이트[성공]
	public Product updateProduct(Product product);
	
	// goods 업데이트 - DTO
	GoodsDto updateGoodsDto(GoodsDto goodsDto) throws Exception;
	
	// ticket 업데이트 - DTO
	TicketDto updateTicketDto(TicketDto ticketDto) throws Exception;
	/*********************************************/
	
	/******************** INCREASE READCOUNT ********************/	
	// product 조회수 올리기[성공]
	Product increaseReadCount(Product product);
	
	/******************** INCREASE READCOUNT[DTO] ********************/
	ProductDto increaseProductReadCountDto(ProductDto productDto) throws Exception;
	// goods 조회수 올리기 - DTO
	GoodsDto increaseGoodsReadCountDto(GoodsDto goodsDto) throws Exception;

	// ticket 조회수 올리기 - DTO
	TicketDto increaseTicketReadCountDto(TicketDto ticketDto) throws Exception;
	/*************************************************************/

	/******************** 내림차순 ********************/		
	// product 조회수별 내림차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountDesc();
	
	// ticket 조회수별 내림차순 정렬 - DTO	
	GoodsDto GoodsByReadCountDescDto(GoodsDto goodsDto) throws Exception;
	
	// ticket 조회수별 내림차순 정렬 - DTO	
	TicketDto TicketByReadCountDescDto(TicketDto ticketDto) throws Exception;
	
	/*********************************************/	
	
	/******************** 오름차순 ********************/		
	// product 조회수별 오름차순 정렬 [성공]
	public List<Product> getProductOrderByReadCountAsc();
	
	// ticket 조회수별 내림차순 정렬 - DTO	
	GoodsDto GoodsByReadCountAscDto(GoodsDto goodsDto) throws Exception;
	
	// ticket 조회수별 내림차순 정렬 - DTO	
	TicketDto TicketByReadCountAscDto(TicketDto ticketDto) throws Exception;
	/*********************************************/	
	
	/******************** 키워드로 검색 ********************/	
	// 키워드로 검색[성공]
	public List<Product> searchProductsByKeyword(String keyword);
	/*********************************************/	

	/******************** categoryId별로 전체나열 ********************/		
	// product categoryId별 분류
	public List<Product> findByCategoryId(Long categoryId);
	
	// product categoryId별로 전체나열 - DTO	
	List<ProductDto> findByProductCategoryId(Long categoryId);
		
	// ticket categoryId별로 전체나열 - DTO	
	List<TicketDto> findTicketByCategoryId(Long categoryId);
		
	// goods categoryId별로 전체나열 - DTO	
	List<GoodsDto> findGoodsByCategoryId(Long categoryId);
	/*********************************************/	
	
	// product category별 분류
	List<Product> findByProductCategory(ProductCategory categoryId);
	
	// productNo 찾기[성공]
	public Optional<Product> findByProductNo(Long productNo);
	
//	// productName 찾기
//	public Product findByProductName(String productName);
//	
//	// productArtist 찾기
//	public Product findByProductAtrist(String productArtist);

	/******************** INCREASE READCOUNT[DTO] ********************/




	
}
