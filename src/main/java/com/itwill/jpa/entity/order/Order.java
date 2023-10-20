package com.itwill.jpa.entity.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jpa.dto.order.OrderDto;
import com.itwill.jpa.entity.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders") //클래스 이름이 테이블명과 같지 않기 때문에 해당 어노테이션 추가
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder //Dto를 Entity로 변환하는 메서드를 쓰기위해서 사용함

//데이터베이스에 들어갈 중요한 데이터를 포함한 객체(Entity)
public class Order {
	
	
	/*멤버필드*/
	
	
	@Id
	@SequenceGenerator(name = "ORDER_ORDER_NO_SEQ",sequenceName = "ORDER_ORDER_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_ORDER_NO_SEQ")
	//PK 주문 번호
	private Long orderNo;
	
	private int orderPrice;
	
	//주문 날짜시간
	private LocalDateTime orderDate;
	
	//주문 진행상황
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	/*메서드*/
	
	
	//주문 진행상황 표시를 위한 enum(상수)타입 메서드
	public enum OrderStatus {
		결제완료, 배송준비중, 배송중, 배송완료
	}
	
	//Dto -> entity 변환해주는 매서드
	public static Order toEntity(OrderDto dto) {
		
		return Order.builder()
				.orderStatus(dto.getOrderStatus())
				.build();	
	}
	
	//order와 delivery 1대1
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	
	// order와 user n대1
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "userId")
	private User user;
	
	//order와 orderitem 1대n
	@OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
	@Builder.Default
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
}
