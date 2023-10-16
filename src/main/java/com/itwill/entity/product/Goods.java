package com.itwill.entity.product;

import java.sql.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("goods")
@Getter @Setter
public class Goods {
	private String content;
	private String reply;
	private Date date;
	private String star;
	
}
