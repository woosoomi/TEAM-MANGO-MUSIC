package com.itwill.jpa.entity.product;

import lombok.Getter;
import lombok.Setter;
import com.itwill.jpa.entity.product.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
	
 @Id @GeneratedValue
 @Column(name = "categoryid")
 private Long id;
 private String name;
 
 @ManyToMany
 @JoinTable(name = "categoryproduct",
 joinColumns = @JoinColumn(name = "categoryid"),
 inverseJoinColumns = @JoinColumn(name = "productid"))
 
 private List<Product> products = new ArrayList<>();
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "parentid")
 private Category parent;
 
 @OneToMany(mappedBy = "parent")
 private List<Category> child = new ArrayList<>();
 
 //==연관관계 메서드==//
 public void addChildCategory(Category child) {
	 
 this.child.add(child);
 child.setParent(this);
 }
}
