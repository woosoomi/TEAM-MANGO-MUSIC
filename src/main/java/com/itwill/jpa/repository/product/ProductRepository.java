package com.itwill.jpa.repository.product;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;


@Repository
//@RequiredArgsConstructor
public interface ProductRepository extends JpaRepository<Product, Long>{

//	private final EntityManager em;
//	
//    public void insert(Product product) {
//        if(product.getProductId() == null) {
//            em.persist(product);
//        }else {
//            em.merge(product);
//        }
//     }	
//    public Product findOneById(Long id) {
//        return em.find(Product.class, id);
//    }
//
//    public List<Product> findAll() {
//        return em.createQuery("select p from Product p",Product.class)
//                .getResultList();
//    }    
}
