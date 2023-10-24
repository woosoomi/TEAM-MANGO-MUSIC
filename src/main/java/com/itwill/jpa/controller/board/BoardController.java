package com.itwill.jpa.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.service.board.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
//@RequestMapping("/board")
@RequiredArgsConstructor //Lombok 라이브러리
public class BoardController {
	
//	private BoardServiceImpl boardServiceImpl;
//	
//    @GetMapping("/events")
//    public String eventPage(Model model) {
//        List<Board> events = boardServiceImpl.findBycategory(2L);
//        model.addAttribute("events", events); 
//        return "board/event"; 
//    }
//	//미완성
}
