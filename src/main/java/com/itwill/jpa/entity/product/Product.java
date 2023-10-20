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

		private String productMovie; // 음악 뮤직비디오
		private String productArtist; // 음악 아티스트
		private String productContent; // 음악 설명
		private String productReply; // 음악 댓글
		private String productStar; // 음악 별점
		private Date productDate; // 음악 등록날짜
		private Long readCount; // 음악 조회수
	}

	/** goods **/
	@Entity
	@DiscriminatorValue("goods")
	public class Goods extends Product {
		// private String content; // 굿즈 설명
		// private String reply; // 굿즈 댓글
		// private Date date; // 굿즈 등록날짜
		// private String star; // 굿즈 뱔점
		private int productStock; // 굿즈 재고
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
	
}
