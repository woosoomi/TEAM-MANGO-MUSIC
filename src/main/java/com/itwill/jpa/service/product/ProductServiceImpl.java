package com.itwill.jpa.service.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.dao.product.ProductDao;
import com.itwill.jpa.dto.product.GoodsDto;
import com.itwill.jpa.dto.product.ProductCategoryDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.TicketDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;
import com.itwill.jpa.entity.product.ProductCategory;
import com.itwill.jpa.exception.product.NotEnoughProductStockException;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	ProductDao productDao;
	
	// productNo 찾기[성공]	
	@Override
	public Optional<Product> findByProductNo(Long productNo) {
		return productRepository.findById(productNo);
	}
	
	// productName 찾기	
	@Override
	public Product findByProductName(String productName) {
		return productRepository.findByProductName(productName);
	}
	
	// productArtist 찾기
	@Override
	public Product findByProductAtrist(String productArtist) {
		return productRepository.findByProductArtist(productArtist);
	}
	
	@Override
	public List<Product> findByCategoryId(Long categoryId) {
//		return productRepository.findByCategoryId(categoryId);
		return null;
	}
	
	@Override
	public Product getProduct(Long productNo) {
		return productRepository.findById(productNo).get();
	}
	
	/*
	 * @Override public Product saveProduct(Product product) { return
	 * productRepository.save(product); }
	 */
	
	
	@Override
	public List<Product> productList() {
		return productRepository.findAll();
	}
	
	// 좋아요 누르기 기능[성공]
	@Override
	public Long checkLikeService(Long productNo) {
		Product findProduct = productRepository.findById(productNo).get();
		Long checkLike = Long.valueOf(findProduct.getProductStar());
		if(checkLike%2==1) {
			checkLike=1L;
		}else if(checkLike%2==0) {
			checkLike=0L;
		}
		return checkLike;
	}
	
	// 품절 안내 기능[성공]
	@Override
	   public Product outOfStockMsg(Long productNo) {
	      Product findProduct =productRepository.findById(productNo).get();
	      String msg="";
	      int stockCount=findProduct.getProductStock();
	      
	      if(stockCount==0) {
	         throw new NotEnoughProductStockException("품절된 상품입니다.");
	      }else {
	         msg=stockCount+"개 남았습니다.";
	      }
	      System.out.println(msg);
	      return null;
	   }
/******************** insert ********************/	
	//product 추가[성공]
	@Override
	public Product insertProduct(Product product) {
		return productRepository.save(product);
	}
	
	//music 추가[성공]
	@Override
	public Music insertMusic(Music music) {
		return productRepository.save(music);
	}
	//goods 추가[성공]
	@Override
	public Goods insertGoods(Goods goods) {
		return productRepository.save(goods);
	}
	//ticket 추가[성공]
	@Override
	public Ticket insertTicket(Ticket ticket) {
		return productRepository.save(ticket);
	}
	//membership 추가[성공]
	@Override
	public Membership insertMembership(Membership membership) {
		return productRepository.save(membership);
	}
	/*********************************************/
	//product 삭제[성공]	
	@Override
	public void deleteProduct(Long productNo) throws Exception {
		productRepository.deleteById(productNo);
		
	}
	
	//product 삭제[성공]
	
	  @Override
	  public void deleteProduct2(Long productNo) { 
		  Optional<Product> productOptional = productRepository.findById(productNo);
	  if(productOptional.isPresent()) { 
		  Product product = productOptional.get();
		  productRepository.delete(product); //product 객체 있으면 꺼내서 삭제
		  }else {	  
	  //예외처리
	  }
		
	}
	 
	//product 수정[성공]
	@Override
	public Product updateProduct(Product product) {
		Product isProduct = productRepository.findById(product.getProductNo()).orElse(null);
		if(isProduct != null) {
			isProduct.setProductCategory(product.getProductCategory()); // product 카테고리 수정
			isProduct.setProductName(product.getProductName()); // product 이름 수정
			isProduct.setProductPrice(product.getProductPrice()); // product 가격 수정
			isProduct.setProductStar(product.getProductStar()); // product 좋아요 수정
			isProduct.setProductContent(product.getProductContent()); // product 설명 수정
			isProduct.setProductReply(product.getProductReply()); // product 댓글 수정
			isProduct.setReadCount(product.getReadCount()); // product 조회수 수정
			isProduct.setProductStock(product.getProductStock()); // product 재고 수정
			isProduct.setProductImage(product.getProductImage()); // product 이미지 수정
			isProduct.setProductMovie(product.getProductMovie()); // music 뮤직비디오 수정
			isProduct.setProductArtist(product.getProductArtist()); // product 아티스트 수정
			isProduct.setProductAddress(product.getProductAddress()); // 콘서트 장소 수정
			isProduct.setStartPeriod(product.getStartPeriod()); // membership 시작날짜 수정
			isProduct.setPeriodOfUse(product.getPeriodOfUse()); // membership 사용기간 수정
			return productRepository.save(isProduct); //수정내용 저장
		}else {
			//제품 없으면 예외처리
			throw new EntityNotFoundException("제품을 찾을 수 없습니다.");
		}
	}
	
	// product 카테고리별 구분[성공]
	@Override
	public List<Product> findByProductCategory(ProductCategory categoryId) {
		return productRepository.findByProductCategory(categoryId);
	}
	
	// product 조회수 올리기[성공]
	@Override
	public Product increaseReadCount(Product product) {
        // 현재 조회수를 가져와서 1 증가
        Long currentReadCount = product.getReadCount();
        Long newReadCount = currentReadCount + 1L; // 1을 Long으로 캐스팅해서 증가
        
        // 증가된 조회수를 엔티티에 설정
        product.setReadCount(newReadCount);

        // 업데이트된 엔티티를 저장하고 반환
        return productRepository.save(product);
	}
	
	// product 조회수별 내림차순 정렬[성공]
	public List<Product> getProductOrderByReadCountDesc() {
		Sort sort = Sort.by(Sort.Direction.DESC, "readCount");
		return productRepository.findAll(sort);
	}
	
	// product 조회수별 오름차순 정렬[성공]
	public List<Product> getProductOrderByReadCountAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "readCount");
		return productRepository.findAll(sort);
	}
	
	//제목키워드로 검색[진행중]
	@Override
	public List<Product> searchProductsByKeyword(String keyword) {
		return productRepository.findByProductNameContaining(keyword);
	}
	/*========================== [DTO] *==========================*/	
	
	/******************** INSERT[DTO] ********************/
	
	// goods 등록 - DTO	
	@Override
	public GoodsDto insertGoodsDto(GoodsDto goodsDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ticket 등록 - DTO
	@Override
	public TicketDto insertTicketDto(TicketDto ticketDto) {
		// TODO Auto-generated method stub
		return null;
	}
	/*********************************************/
	
	/******************** DELETE[DTO] ********************/	
	// goods 삭제 - DTO	
	@Override
	public GoodsDto deledtGoodsDto(GoodsDto goodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ticket 삭제 - DTO	
	@Override
	public TicketDto deleteTicketDto(TicketDto ticketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*********************************************/

	/******************** UPDATE[DTO] ********************/	
	// goods 수정 - DTO
	@Override
	public GoodsDto updateGoodsDto(GoodsDto goodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ticket 수정 - DTO
	@Override
	public TicketDto updateTicketDto(TicketDto ticketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/*********************************************/
	
	/******************** INCREASE READCOUNT[DTO] ********************/
	// goods 조회수 올리기 - DTO	
	@Override
	public GoodsDto increaseGoodsReadCountDto(GoodsDto goodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	// ticket 조회수 올리기 - DTO
	@Override
	public TicketDto increaseTicketReadCountDto(TicketDto ticketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/*********************************************/
	
	/******************** 내림차순[DTO] ********************/		
	@Override
	public GoodsDto GoodsByReadCountDescDto(GoodsDto goodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketDto TicketByReadCountDescDto(TicketDto ticketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*********************************************/
	/******************** 오름차순[DTO] ********************/
	@Override
	public GoodsDto GoodsByReadCountAscDto(GoodsDto goodsDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketDto TicketByReadCountAscDto(TicketDto ticketDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*********************************************/
	
	/******************** categoryId별로 전체나열 ********************/
	
	// goods categoryId별로 전체나열 - DTO
	@Override
	public List<GoodsDto> findGoodsByCategoryId(Long categoryId) {
		List<Goods> goodsList = productDao.getGoodsByCategoryId(categoryId);
		List<GoodsDto> goodsDtoList = new ArrayList<GoodsDto>();
		for (Goods goods : goodsList) {
			goodsDtoList.add(GoodsDto.toDto(goods));
		}
		return goodsDtoList;
	}
	// ticket categoryId별로 전체나열 - DTO
	@Override
	public List<TicketDto> findTicketByCategoryId(Long categoryId) {
		List<Ticket> ticketList = productDao.getTicketByCategoryId(categoryId);
		List<TicketDto> ticketDtoList = new ArrayList<TicketDto>();
		for (Ticket ticket : ticketList) {
			ticketDtoList.add(TicketDto.toDto(ticket));
		}
		return ticketDtoList;
	}
	/*********************************************/	



}
