package com.itwill.jpa.repository.product;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Music;


@Repository
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
//	List<Music> findAllMusicByProductNoDesc(); // 음악 내립차순 정렬
	
}
