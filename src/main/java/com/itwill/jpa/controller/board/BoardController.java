package com.itwill.jpa.controller.board;

import java.util.List;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.service.board.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/event")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardServiceImpl boardServiceImpl;
    
    @GetMapping // 경로를 "/event"로 설정
    public String eventPage(Model model) {
        try {
            List<Board> events = boardServiceImpl.findBycategory(2L);
            model.addAttribute("events", events);
            System.out.println("이벤트 리스트 :"+events);
            return "event"; // 뷰 템플릿의 경로를 "event"로 설정
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMSG : " + e.getMessage());
            return null;
        }
    }
}


