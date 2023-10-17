package com.itwill.jpa.entity.product;

import java.sql.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue("goods")
@Getter @Setter
public class Goods extends Product {
//	private String content;
//	private String reply;
//	private Date date;
//	private String star;
//	
//	private int stock;
	
}
