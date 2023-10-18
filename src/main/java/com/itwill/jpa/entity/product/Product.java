package com.itwill.jpa.entity.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
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
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "productid")
	private Long productId;

	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int productPrice;
	@ManyToMany(mappedBy = "products")
	private List<Category> categories = new ArrayList<Category>();

	/** music **/
	@Entity
	@DiscriminatorValue("MUSIC")
	@Getter
	public class Music extends Product {
		private String productMovie;
		private String productArtist;
		private String productContent;
		private String productReply;
		private String productStar;
		private Date productDate;
		private Long readCount;
	}

	/** goods **/
	@Entity
	@DiscriminatorValue("GOODS")
	@Getter
	public class Goods extends Product {
		// private String content;
		// private String reply;
		// private Date date;
		// private String star;
		private int productStock;
	}

	/** ticket **/
	@Entity
	@DiscriminatorValue("MUSIC")
	@Getter
	public class Ticket extends Product {
		private String productAddress;
		// private String content;
		// private String reply;
		// private Date date;

		// private Long readCount;
		// private int stock;
	}

	/** membership **/
	@Entity
	@DiscriminatorValue("MEMBERSHIP")
	@Getter
	public class Membership extends Product {
		private Date startPeriod;
		private int periodOfUse;
	}
	// private User userId;

}
