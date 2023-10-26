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
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardServiceImpl boardServiceImpl;
    
//    @GetMapping("/event")
//    public String eventPage(Model model) {
//        try {
//            List<Board> events = boardServiceImpl.findBycategory(2L);
//            model.addAttribute("events", events);
//            System.out.println("이벤트 리스트 :"+events);
//            return "event"; // 뷰 템플릿의 경로를 "event"로 설정
//        } catch (Exception e) {
//            e.printStackTrace();
//            model.addAttribute("errorMSG : " + e.getMessage());
//            return null;
//        }
//    }
    
    @GetMapping("/notification")
    public String notificationPage(Model model) {
    	try {
    		List<Board> notifications = boardServiceImpl.findBycategory(1L);
    		model.addAttribute("notifications",notifications);
    		System.out.println("notifications리스트 : " + notifications);
    		return "notification";
    	}catch (Exception e) {
    		e.printStackTrace();
            model.addAttribute("errorMSG : " + e.getMessage());
            return null;
		}
    }
    
    @GetMapping("/magazine")
    public String magazine(Model model) {
    	try {
    		List<Board> magazines = boardServiceImpl.findBycategory(3L);
    		model.addAttribute("magazines",magazines);
    		System.out.println("magazine 리스트 : " + magazines);
    		return "magazine";
    	}catch (Exception e) {
    		e.printStackTrace();
            model.addAttribute("errorMSG : " + e.getMessage());
            return null;
		}
    }
    @GetMapping("/inquiries")
    public String inquiries(Model model) {
    	try {
    		List<Board> inquiriesList = boardServiceImpl.findBycategory(4L);
    		model.addAttribute("inquiries",inquiriesList);
    		System.out.println("inquiries 리스트 : " + inquiriesList);
    		return "inquiries";
    	}catch (Exception e) {
    		e.printStackTrace();
            model.addAttribute("errorMSG : " + e.getMessage());
            return null;
		}
    }
    @GetMapping("/faq")
    public String faq(Model model) {
    		return "faq";
    }
}


