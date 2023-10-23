package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.board.BoardCategory;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//    Product insertProduct(Product product);

//    Product findOne(Long productNo);
    
//    List<Product> findAll();

//    Product findbyId(Long productNo);

//	keyword가 포함된 title 찾기
    List<Product> findByProductNameContaining(String keyword);
}
