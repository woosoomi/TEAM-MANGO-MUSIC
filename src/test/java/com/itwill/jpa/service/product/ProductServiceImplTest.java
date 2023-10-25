package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;
@SpringBootTest
class ProductServiceImplTest {
	@Autowired
	ProductServiceImpl productServiceImpl;
    @Autowired
    
    private ProductRepository productRepository;	

    
	// productNo 찾기[성공]   
    @Test
    @Transactional
    @Rollback(false)
//    @Disabled
    public void testFindByProductNo() {       
        Long productNo = 1L; // 제품 번호 지정
        Optional<Product> productOptional = productServiceImpl.findByProductNo(productNo); // 제품 조회
        System.out.println("찾은 번호" + productOptional);

    }

	// productName 찾기
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    public void testFindByProductName() {
        // 제품 이름 지정
        String productName = "음악 제품 1";
        // 제품을 조회합니다.
        Product product = productServiceImpl.findByProductName(productName);

    }

	// productArtist 찾기
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    public void testFindByProductArtist() {
        // 아티스트 지정
        String productArtist = "아티스트 1";

        // 아티스트 조회
        Product product = productServiceImpl.findByProductAtrist(productArtist);

    }
    
	// 카테고리별 구분 --성공
	/*
	 * @Test
	 * 
	 * @Transactional
	 * 
	 * @Rollback(false) //@Disabled void findByProductCategory() { List<Product>
	 * products = new ArrayList<Product>(); products =
	 * productServiceImpl.findByProductCategory(1L); // 1대1문의 찾기
	 * System.out.println("music 모음 >>>>>" + products); }
	 */
    
	//product 추가[성공]    
    @Test
    @Transactional
    @Rollback(false)
    @Disabled
    public void testInsertProduct() {
        // 새로운 Product 객체를 생성
        Product product = new Product();
        product.setProductName("새로운 제품");
        product.setProductPrice(10000);

        // 제품 추가
        Product insertedProduct = productServiceImpl.insertProduct(product);

        // 제품 추가 확인
        assertNotNull(insertedProduct.getProductNo());
        assertEquals("새로운 제품", insertedProduct.getProductName());
        assertEquals(10000, insertedProduct.getProductPrice());

        // 추가된 제품 확인
        Product retrievedProduct = productServiceImpl.getProduct(insertedProduct.getProductNo());
        assertEquals(insertedProduct.getProductNo(), retrievedProduct.getProductNo());
        assertEquals("새로운 제품", retrievedProduct.getProductName());
        assertEquals(10000, retrievedProduct.getProductPrice());
    }

    //product 삭제[성공]	    
    @Test
    @Transactional
	@Disabled
    public void testDeleteProduct() throws Exception {
    	// 삭제하려는 제품번호 지정
    	Long productNo = 1L;
    	// 제품 삭제
    	productServiceImpl.deleteProduct(productNo);
    }
    
    /*
     * @Test
     * 
     * @Transactional
     * 
     * @Disabled public void testDeleteProduct2() { // 삭제하려는 제품의 번호 지정 Long
     * productNo = 2L;
     * 
     * // 제품을 삭제합니다. productServiceImpl.deleteProduct2(productNo);
     * 
     * }
     */  
	//product 수정[성공]   
    @Test
    @Transactional
    @Rollback(false)
    @Disabled    
    public void testUpdateProduct() {
        Long productNo = 1L;
        Product product = productServiceImpl.getProduct(productNo);
        // 수정
        product.setProductName("수정 테스트완료");

        // updateProduct 메서드 호출
        Product updatedProduct = productServiceImpl.updateProduct(product);
    }

	//제목키워드로 검색[진행중]    
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	void searchProductsByKeywordTest() {
		String keyword = "음악 제품 설명1";
		List<Product> products = productServiceImpl.searchProductsByKeyword(keyword);
		System.out.println("검색결과>>>" + products);
	}
	
	// product 조회수별 내림차순 정렬[성공]	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	public void testGetProductOrderByReadCountDesc() {
		List<Product> products = productServiceImpl.getProductOrderByReadCountDesc();
		for (Product product : products) {
			System.out.println("Product Name : " + product.getProductName() + "///Read Count : " + product.getReadCount());
		}
	}
	
	// product 조회수별 오름차순 정렬[성공]	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	public void testGetProductOrderByReadCountAsc() {
		List<Product> products = productServiceImpl.getProductOrderByReadCountAsc();
		for (Product product : products) {
			System.out.println("Product Name : " + product.getProductName() + "///Read Count : " + product.getReadCount());
		}
	}
	
	// product 조회수 올리기[성공]	
	@Test
	@Transactional
	@Rollback(false)
	@Disabled
	    public void testIncreaseReadCount() {
		 	Optional<Product> productOptional = productRepository.findById(5L);
		 	if(productOptional.isPresent()) {
		 		// 엔티티가 존재할 경우
		 		Product product = productOptional.get();
		 		// readCount 증가
		 		product.setReadCount(product.getReadCount() + 1);
		 		// 변경사항 저장
		 		productRepository.save(product);
		 	}else {
		 		// 엔티티 못찾았을 경우의 예외처리		 		
		 	}
	    }	
}
