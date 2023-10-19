package com.itwill.jpa.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.itwill.jpa.entity.Board.Board;
import com.itwill.jpa.entity.product.*;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private Long categoryId;
	private String categoryName;

	/*
	 * @OneToMany(mappedBy = "category",cascade = CascadeType.PERSIST) private
	 * List<Product> products = new ArrayList<>();
	 * 
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "parent_id") private Category parent;
	 * 
	 * @OneToMany(mappedBy = "parent") private List<Category> child = new
	 * ArrayList<>();
	 * 
	 * //==연관관계 메서드==// public void addChildCategory(Category child) {
	 * 
	 * this.child.add(child); child.setParent(this); }
	 */
}
