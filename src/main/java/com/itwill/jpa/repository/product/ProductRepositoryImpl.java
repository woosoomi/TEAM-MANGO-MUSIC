package com.itwill.jpa.repository.product;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductSearch;

import io.micrometer.common.util.StringUtils;
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

	public Product findOne(Long productNo) {
		return em.find(Product.class, productNo); }

	public List<Product> findAll() {
		return em.createQuery("select product from Product product",
				Product.class).getResultList();
	}
	
	/*
	 * public List<Product> findAllBySearch(ProductSearch productSearch) { if
	 * (StringUtils.hasText(ProductSearch.getMemberName())) { if (isFirstCondition)
	 * { jpql += " where"; isFirstCondition = false; } else { jpql += " and"; } jpql
	 * += " m.name like :name"; } TypedQuery<Order> query = em.createQuery(jpql,
	 * Order.class) .setMaxResults(1000); //최대 1000건 if
	 * (orderSearch.getOrderStatus() != null) { query = query.setParameter("status",
	 * orderSearch.getOrderStatus()); } if
	 * (StringUtils.hasText(orderSearch.getMemberName())) { query =
	 * query.setParameter("name", orderSearch.getMemberName()); } return
	 * query.getResultList(); } }
	 */
}
