package com.itwill.jpa.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.board.BoardReplyDto;
import com.itwill.jpa.dto.product.ProductReplyDto;
import com.itwill.jpa.entity.board.BoardReply;
import com.itwill.jpa.entity.product.ProductReply;
import com.itwill.jpa.service.product.ProductServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class ProductRestController {
//프로덕트(음악,굿즈,티켓) 생성, 제거, 수정, 
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Operation(summary = "댓글등록")
	@PostMapping("product_reply_create/{productNo}")
	public ResponseEntity<ProductReplyDto> createProductReply(@PathVariable(name="productNo") Long productNo, @RequestBody ProductReplyDto productReplyDto) {
	    try {
	    	ProductReply productReply =ProductReply.toEntity(productReplyDto);
	    	ProductReply createReply = productServiceImpl.ReplyInsert(productReply);
	    	ProductReplyDto createReplyDto = ProductReplyDto.toDto(createReply);
	    	return new ResponseEntity<>(createReplyDto, HttpStatus.CREATED);
	    }catch (Exception e) { 
	    	e.printStackTrace();
	    	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
		
	}
	/*
	 * @Operation(summary = "조회수별 내림차순 정렬")
	 * 
	 * @GetMapping
	 */
}
