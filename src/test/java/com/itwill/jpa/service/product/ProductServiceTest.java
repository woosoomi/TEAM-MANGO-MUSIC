package com.itwill.jpa.service.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.exception.NotEnoughProductStockException;
import com.itwill.jpa.repository.product.ProductRepository;

import jakarta.persistence.EntityManager;

//@Runwith(SpringRunner.class)
@SpringBootTest
@Transactional
class ProductServiceTest {

   @Autowired
   EntityManager em;
   @Autowired 
   ProductService productService;
   @Autowired
   ProductRepository productRepository;
   
   public void insertProduct() throws Exception {
      //given
      Product product= new Product();
      product.setProductName("아름다운사실");
      product.setProductContent("명곡입니다.");
      product.setProductReply("아름다워요");
      product.setProductStar("5");
      product.setProductArtist("부활");
      em.persist(product);
      
      //when
     // Optional<Product> productNo = productService.findOneProduct(product.getProductNo());
      //then
      
      //Product findMusic = productRepository.findOneMusic(productNo);
   }
      
}