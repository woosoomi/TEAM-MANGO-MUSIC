package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;

import jakarta.persistence.EntityManager;
@Repository
public class ProductRepositoryImpl {
	
	private final EntityManager em;
	public ProductRepositoryImpl(EntityManager em) {
		this.em = em;
	}
	
	public Product insertProduct(Product product) {
		if (product.getProductNo() == null) {
			em.persist(product);
			} else {
			em.merge(product);
	  }
		return product;
}

	//Product 찾기

	public Product findOne(Long productNo) { return em.find(Product.class, productNo); }

	public List<Product> findAll() { return
	  em.createQuery("select product from Product product",
	  Product.class).getResultList(); }
}
