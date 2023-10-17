package com.itwill.entity.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Product {
	 @Id @GeneratedValue
	 @Column(name = "productId")
	 private Long id;
	 
	 @Column(nullable = false)
	 private String name;
	 @Column(nullable = false)
	 private int price;
	 @ManyToMany(mappedBy = "products")
	 private List<Category> categories = new ArrayList<Category>();
	}

