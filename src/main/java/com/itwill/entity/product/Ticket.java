package com.itwill.entity.product;

import java.sql.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("ticket")
@Getter @Setter
public class Ticket {
	private String content;
	private String reply;
	private Date date;
	private String address;
	
}
