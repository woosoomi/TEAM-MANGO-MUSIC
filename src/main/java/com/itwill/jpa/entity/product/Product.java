package com.itwill.jpa.entity.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import com.itwill.jpa.dto.product.ProductDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Product {
	@Id
	@SequenceGenerator(name = "PRODUCT_PRODUCT_NO_SEQ",sequenceName = "PRODUCT_PRODUCT_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_PRODUCT_NO_SEQ")
	@Column(name = "product_no")
	private Long productNo;

	@Column(nullable = false)
	private String productName;
	@Column(nullable = false)
	private int productPrice;
	
	//(c)1:N(p)
	/*
	 * @ManyToOne(cascade = CascadeType.PERSIST)
	 * 
	 * @JoinColumn(name="category_id") private List<Category> categories = new
	 * ArrayList<Category>();
	 */
	/** music **/
	@Entity
	@DiscriminatorValue("music")
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
	@DiscriminatorValue("goods")
	public class Goods extends Product {
		// private String content;
		// private String reply;
		// private Date date;
		// private String star;
		private int productStock;
	}

	/** ticket **/
	@Entity
	@DiscriminatorValue("ticket")
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
	@DiscriminatorValue("membership")
	public class Membership extends Product {
		private Date startPeriod;
		private int periodOfUse;
	}
	// private User userId;

	public static Product toEntity(ProductDto productDto) {
		return Product.builder()
				.productName(productDto.getProductName())
				.productPrice(productDto.getProductPrice())
				.build();
	}
	
}
