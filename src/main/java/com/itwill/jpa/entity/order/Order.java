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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders") //클래스 이름이 테이블명과 같지 않기 때문에 해당 어노테이션 추가
@NoArgsConstructor
@AllArgsConstructor
@Getter //데이터베이스와 연관된 엔티티 정보를 임의로 수정하는 것으로 부터 보호하기 위해서 Data가 아닌 Getter만 사용함
@Builder //Dto를 Entity로 변환하는 메서드를 쓰기위해서 사용함

//데이터베이스에 들어갈 중요한 데이터를 포함한 객체(Entity)
public class Order {
	
	
	/*멤버필드*/
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//PK 주문 번호
	private Long orderId;
	
	//주문 날짜시간
	private LocalDateTime orderDate;
	
	//주문 진행상황
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	//FK 주문을 넣은 유저정보(다대일 관계 매핑)
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	//주문 제품들(일대다 관계 매핑), 매핑된 엔티티 끼리 변경된 정보를 전부 공유하도록 설정
	@OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	
	
	/*메서드*/
	
	
	//주문 진행상황 표시를 위한 enum(상수)타입 메서드
	public enum OrderStatus {
	        결제완료, 주문완료, 주문취소
	}
	
	//Dto -> entity 변환해주는 매서드
	public static Order toEntity(OrderDto dto) {
		return Order.builder()
					.orderDate(dto.getOrderDate())
					.orderStatus(dto.getOrderStatus())
					.orderItems(dto.getOrderItems())
					.build();	
	}

}
