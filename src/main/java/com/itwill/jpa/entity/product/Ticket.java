package com.itwill.jpa.entity.product;

import java.sql.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ticket")
@Getter @Setter
public class Ticket extends Product {
	private String content;
	private String reply;
	private Date date;
	private String address;
	
}
