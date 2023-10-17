package com.itwill.jpa.entity.product;

import java.sql.Date;
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
@DiscriminatorColumn(name = "DTYPE")
@Getter
@Setter
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "productId")
	private Long id;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int price;
	@ManyToMany(mappedBy = "products")
	private List<Category> categories = new ArrayList<Category>();

	/** music **/
	@Entity
	public class Music extends Product {
		private String movie;
		private String artist;
		private String content;
		private String reply;
		private String star;
		private Date date;
		private Long readCount;
	}

	/** goods **/
	@Entity
	public class Goods extends Product {
		// private String content;
		// private String reply;
		// private Date date;
		// private String star;
		private int stock;
	}

	/** ticket **/
	public class Ticket extends Product {
		private String address;
		// private String content;
		// private String reply;
		// private Date date;

		// private Long readCount;
		// private int stock;
	}

	/** membership **/
	@Entity
	public class Membership extends Product {
		private Date startPeriod;
		private int periodOfUse;
	}
	// private User userId;

}
