package com.itwill.jpa.entity.Board;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MAGAZINE") 
public class Magazine extends Board {
    private String boardImage;

}