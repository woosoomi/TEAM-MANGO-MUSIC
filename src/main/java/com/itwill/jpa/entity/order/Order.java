package com.itwill.jpa.entity.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders") //클래스 이름이 테이블명과 같지 않기 때문에 해당 어노테이션 추가
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//데이터베이스에 들어갈 중요한 데이터를 포함한 객체
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long orderid; //PK

	private LocalDateTime orderdate;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderstatus;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user; //FK

	@OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
	private List<OrderItem> orderitems = new ArrayList<OrderItem>();

	public enum OrderStatus {
	        결제완료, 주문완료, 주문취소
	}
}
