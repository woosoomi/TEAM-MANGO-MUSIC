package com.itwill.jpa.controller.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.jpa.entity.board.Board;
import com.itwill.jpa.entity.board.BoardType;
import com.itwill.jpa.service.board.BoardServiceImpl;
import com.itwill.jpa.service.user.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

	private final BoardServiceImpl boardServiceImpl;

	private UserServiceImpl userServiceImpl;

	@GetMapping("/event")
	public String eventPage(Model model) {
		try {
			List<Board> events = boardServiceImpl.findBycategory(2L);
			model.addAttribute("events", events);
			System.out.println("이벤트 리스트 :" + events);
			return "event"; // 뷰 템플릿의 경로를 "event"로 설정
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/notification")
	public String notificationPage(Model model) {
		try {
			List<Board> notifications = boardServiceImpl.findBycategory(1L);
			model.addAttribute("notifications", notifications);
			System.out.println("notifications리스트 : " + notifications);

			List<BoardType> boardTypes = boardServiceImpl.findAllByOrderByTypeIdAsc();
			System.out.println("boardTypeList" + boardTypes);
			model.addAttribute("boardTypes", boardTypes);

			return "notification";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/magazine")
	public String magazine(Model model) {
		try {
			List<Board> magazines = boardServiceImpl.findBycategory(3L);
			model.addAttribute("magazines", magazines);
			System.out.println("magazine 리스트 : " + magazines);

			List<Board> sortedMagazines = new ArrayList<>(magazines); // magazines를 복사하여 새로운 리스트 생성

			sortedMagazines.sort(Comparator.comparing(Board::getBoardReadCount).reversed());
			
			List<Board> top3Magazines = sortedMagazines.subList(0, Math.min(sortedMagazines.size(), 3));
			model.addAttribute("top3Magazines", sortedMagazines);
			System.out.println("탑3매거진리스트 : " + sortedMagazines);

			return "magazine";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/inquiries")
	public String inquiries(Model model) {
		try {
			List<Board> inquiries = boardServiceImpl.findByBoardCategory_IdAndUser_UserIdOrderByCreatedTime(4L,
					"why3795");
			Collections.reverse(inquiries);

			model.addAttribute("inquiries", inquiries);
			System.out.println("inquiries 리스트 : " + inquiries);

			return "inquiries";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/faq")
	public String faq(Model model) {
		try {
			List<Board> faqs = boardServiceImpl.findBycategory(5L);
			model.addAttribute("faqs", faqs);
			System.out.println("FAQ 리스트 :" + faqs);
			List<BoardType> boardTypes = boardServiceImpl.findAllByOrderByTypeIdAsc();
			System.out.println("boardTypeList" + boardTypes);
			model.addAttribute("boardTypes", boardTypes);
			return "faq"; // 뷰 템플릿의 경로를 "faq"로 설정

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}

	@GetMapping("/board_write")
	public String board_write(Model model) {
		try {

			return "board_write";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());
			return null;
		}
	}
	
	@GetMapping("/board_detail")
	public String boardDetail(@RequestParam(name = "boardId") Long boardId, Model model) {
	    try {
	        // 게시물 ID를 사용하여 해당 게시물의 정보를 데이터베이스에서 가져옵니다.
	        Optional<Board> boardOptional = boardServiceImpl.findById(boardId);

	        if (boardOptional.isPresent()) {
	            // 게시물 정보가 존재할 경우 모델에 추가하여 뷰에서 사용할 수 있도록 합니다.
	            Board board = boardOptional.get();
	            model.addAttribute("board", board);
	            System.out.println("board :"+board);
	        } else {
	            // 게시물이 존재하지 않을 경우 에러 처리
	            model.addAttribute("errorMSG", "게시물을 찾을 수 없습니다.");
	        }

	        return "board_detail";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMSG", "에러 발생: " + e.getMessage());
	        return "error";
	    }
	}

	
	@GetMapping("/board_detail_edit")
	public String boardDetailEdit(@RequestParam(name = "boardId") Long boardId, Model model) {
	    try {
	        // 게시물 ID를 사용하여 해당 게시물의 정보를 데이터베이스에서 가져옵니다.
	        Optional<Board> boardOptional = boardServiceImpl.findById(boardId);

	        if (boardOptional.isPresent()) {
	            // 게시물 정보가 존재할 경우 모델에 추가하여 뷰에서 사용할 수 있도록 합니다.
	            Board board = boardOptional.get();
	            model.addAttribute("board", board);
	        } else {
	            // 게시물이 존재하지 않을 경우 에러 처리
	            model.addAttribute("errorMSG", "게시물을 찾을 수 없습니다.");
	        }

	        return "board_detail_edit";
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMSG", "에러 발생: " + e.getMessage());
	        return "error";
	    }
	}

}
