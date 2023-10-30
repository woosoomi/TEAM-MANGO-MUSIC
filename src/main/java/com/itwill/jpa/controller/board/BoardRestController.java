package com.itwill.jpa.controller.board;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.jpa.dto.board.BoardDto;
import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.service.board.BoardServiceImpl;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class BoardRestController {
	
	@Autowired
	private BoardServiceImpl boardServiceImpl;
	
	@Operation(summary = "삭제")
	@DeleteMapping("/{boardId}")
	public void BoardDelete(@PathVariable(name="boardId") Long boardId) {
		boardServiceImpl.delete(boardId);
	}
	
	@Operation(summary = "오래된 순서로 정렬")
	@GetMapping
	public ResponseEntity<List<BoardDto>> getSortData(@RequestParam(name="no") Long categoryId, @RequestParam(name="id") String userId) {
		List<Board> boardList = boardServiceImpl.findByBoardCategory_IdAndUser_UserIdOrderByCreatedTime(categoryId, userId);
		List<BoardDto> boardDtoList = new ArrayList<BoardDto>();
		Collections.reverse(boardDtoList);
		
	    for (Board board : boardList) {
	        boardDtoList.add(BoardDto.toDto(board));
	    }
		
	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		
		return new ResponseEntity<>(boardDtoList,httpHeaders,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
