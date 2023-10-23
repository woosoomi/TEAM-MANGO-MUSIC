package com.itwill.jpa.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itwill.jpa.entity.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product insertProduct(Product product);

    //Product findbyId(Long productNo);

}
