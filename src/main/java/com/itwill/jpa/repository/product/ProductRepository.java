package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRepository {

	private final EntityManager em;
	
    public void insert(Product product) {
        if(product.getId() == null) {
            em.persist(product);
        }else {
            em.merge(product);
        }
     }	
    public Product findOneById(Long id) {
        return em.find(Product.class, id);
    }

    public List<Product> findAll() {
        return em.createQuery("select p from Product p",Product.class)
                .getResultList();
    }    
}
