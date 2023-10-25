package com.itwill.jpa.entity.board;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "board_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardType {
    @Id
    @SequenceGenerator(name = "BOARD_TYPE_NO_SEQ",sequenceName = "BOARD_TYPE_NO_SEQ",initialValue = 1 , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_TYPE_NO_SEQ")
    private Long boardTypeId;
    
    private String boardTypeTitle;
    
	//1대N관계설정
	@OneToMany(mappedBy = "boardType", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<BoardCategory> boardCategories = new ArrayList<>();
	
    
}
