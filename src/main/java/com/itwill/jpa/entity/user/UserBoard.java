


package com.itwill.jpa.entity.user;


import com.itwill.jpa.entity.Board.Board;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_board")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBoard {

	@Id
	@SequenceGenerator(name = "USER_BOARD_NO_SEQ",sequenceName = "USER_BOARD_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_BOARD_NO_SEQ")
	public Long userBoardId;
	
	@ManyToOne
	@JoinColumn(name = "board_Id")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
	
	}

