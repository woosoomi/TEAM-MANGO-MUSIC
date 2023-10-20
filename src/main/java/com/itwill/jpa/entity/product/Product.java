package com.itwill.jpa.entity.product;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.entity.cart.CartItem;
import com.itwill.jpa.entity.order.OrderItem;
import com.itwill.jpa.entity.vote.Vote;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Table(name = "product")
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
	
	private String productContent; // 프로덕트(음악,굿즈,콘서트) 설명
	private String productReply; // 프로덕트(음악,굿즈,콘서트) 댓글
	private String productStar; // 프로덕트(음악,굿즈,콘서트) 별점
	private Date productDate; // 프로덕트(음악,굿즈,콘서트) 등록날짜
	private Long readCount; // 프로덕트(음악,콘서트) 조회수
	private int productStock; // 프로덕트(굿즈, 티켓) 재고
	

	/** music **/
	@Entity
	@DiscriminatorValue("music")
	public class Music extends Product {
		private String productMovie; // 음악 뮤직비디오
		private String productArtist; // 음악 아티스트
//		private String productContent; // 프로덕트(음악,굿즈,콘서트) 설명
//		private String productReply; // 프로덕트(음악,굿즈,콘서트) 댓글
//		private String productStar; // 프로덕트(음악,굿즈,콘서트) 별점
//		private Date productDate; // 프로덕트(음악,굿즈,콘서트) 등록날짜
//		private Long readCount; // 프로덕트(음악,콘서트) 조회수
//		private int productStock; // 프로덕트(굿즈, 티켓) 재고
	}

	/** goods **/
	@Entity
	@DiscriminatorValue("goods")
	public class Goods extends Product {
		// private String content; // 굿즈 설명
		// private String reply; // 굿즈 댓글
		// private Date date; // 굿즈 등록날짜
		// private String star; // 굿즈 뱔점
		// private int productStock; // 굿즈 재고
	}

	/** ticket **/
	@Entity
	@DiscriminatorValue("ticket")
	public class Ticket extends Product {
		private String productAddress; // 콘서트 장소
		// private String content; // 콘서트 설명
		// private String reply; // 콘서트 댓글
		// private Date date; // 콘서트 날짜 

		// private Long readCount; // 콘서트 조회수
		// private int stock; // 티켓 재고
	}

	/** membership **/
	@Entity
	@DiscriminatorValue("membership")
	public class Membership extends Product {
		private Date startPeriod; // 멤버십 시작날짜
		private int periodOfUse; // 멤버십 사용기간
	}
	// private User userId;

	public static Product toEntity(ProductDto productDto) {
		return Product.builder()
				.productName(productDto.getProductName())
				.productPrice(productDto.getProductPrice())
				.build();
	}
	
	//product와 orderitem 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	//product와 productcategory  1대1
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category_Id")
	private ProductCategory productCategory;
	
	//product와 cartitem 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<CartItem> cartitems = new ArrayList<CartItem>();
	
	//product와 vote 1대n
	@OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<Vote> vote = new ArrayList<Vote>();
	
}
