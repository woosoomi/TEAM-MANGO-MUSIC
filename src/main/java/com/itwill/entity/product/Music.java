package com.itwill.entity.product;

import java.sql.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("music")
@Getter @Setter
public class Music extends Product{

	private String movie;
	private String content;
	private String reply;
	private String star;
	private Date date;
	
}
