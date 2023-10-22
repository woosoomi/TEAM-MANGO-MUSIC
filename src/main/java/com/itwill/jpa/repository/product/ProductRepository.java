package com.itwill.jpa.repository.product;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.Product.Goods;
import com.itwill.jpa.entity.product.Product.Membership;
import com.itwill.jpa.entity.product.Product.Music;
import com.itwill.jpa.entity.product.Product.Ticket;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class ProductRepository{
	
	private final EntityManager em;
	//Product
	public void insertProduct(Product product) {
		if (product.getProductNo() == null) {
			em.persist(product);
		}else {
			em.merge(product);
		}
	}
	//Music
	public void insertMusic(Product music) {
		if (music.getProductNo() == null) {
			em.persist(music);
		}else {
			em.merge(music);
		}
	}
	//Goods
	public void insertGoods(Product goods) {
		if (goods.getProductNo() == null) {
			em.persist(goods);
		}else {
			em.merge(goods);
		}
	}
	//Ticket
	public void insertTicket(Product ticket) {
		if (ticket.getProductNo() == null) {
			em.persist(ticket);
		}else {
			em.merge(ticket);
		}
	}
	//Membership
	public void insertMembership(Product membership) {
		if (membership.getProductNo() == null) {
			em.persist(membership);
		}else {
			em.merge(membership);
		}
	}	
/*Product 찾기*/
	public Product findOne(Long productNo) {
		return em.find(Product.class, productNo);
	}
	
	public List<Product> findAll() {
		return em.createQuery("select product from Product product", Product.class).getResultList();
	}
/*Music 찾기*/	
	public Music findOneMusic(Long productNo) {
		return em.find(Music.class, productNo);
	}
	
	public List<Music> findAllMusic() {
		return em.createQuery("select music from Music mudic", Music.class).getResultList();
	}
/*Goods 찾기*/	
	public Goods findOneGoods(Long productNo) {
		return em.find(Goods.class, productNo);
	}
	
	public List<Goods> findAllGoods() {
		return em.createQuery("select goods from Goods goods", Goods.class).getResultList();
	}
	
/*Ticket 찾기*/
	public Ticket findOneTicket(Long productNo) {
		return em.find(Ticket.class, productNo);
	}
	
	public List<Ticket> findAllTicket() {
		return em.createQuery("select ticket from Ticket ticket", Ticket.class).getResultList();
	}	
/*Membership 찾기*/	
	public Membership findOneMembership(Long productNo) {
		return em.find(Membership.class, productNo);
	}
	
	public List<Membership> findAllMembership() {
		return em.createQuery("select membership from Membership membership", Membership.class).getResultList();
	}	
}
