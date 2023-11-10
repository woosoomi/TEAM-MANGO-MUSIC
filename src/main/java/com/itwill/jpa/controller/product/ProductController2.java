package com.itwill.jpa.controller.product;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.jpa.controller.user.LoginCheck;
import com.itwill.jpa.dto.product.MusicDto;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.user.UserDto;
import com.itwill.jpa.entity.board.Board;
//import com.itwill.jpa.dto.product.ProductMusicDto;

import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.product.ProductReply;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class ProductController2 {

	@Autowired
	private final ProductService productService;

	@Autowired
	private final UserService userService;

	// 뮤직리스트
	@LoginCheck
	@GetMapping("/product_music_list")
	public String musicList(Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);
//			List<ProductDto> musics = productService.findByProductCategoryId(1L);
//			musics=productService.productByReadCountDescDto(1L);
			List<ProductDto> musics = productService.findByProductCategoryId(1L);
			musics = productService.productByReadCountDescDto(1L);
			model.addAttribute("musics", musics);
			return "product_music_list";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 최신 뮤직리스트
	@LoginCheck
	@GetMapping("/product_music_newest")
	public String musicNewestList(Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);

			List<ProductDto> newestMusic = productService.findByProductCategoryId(1L);
			newestMusic = productService.productListByOlder(1L); // 서비스 메서드 older랑 newer 반대로 됐음.
			model.addAttribute("newestMusic", newestMusic);
			return "product_music_newest";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 뮤직디테일 -> https://www.baeldung.com/spring-mvc-404-error
	@LoginCheck
	@GetMapping("/product_music_detail")
	public String MusicDetail(@RequestParam(name = "productNo") Long productNo, Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);

			Optional<Product> findMusicOptional = productService.findByProductNo(productNo);
			List<ProductReply> replyList = productService.findByProduct_productNo(productNo);

			if (findMusicOptional.isPresent()) {
				Product findMusic = findMusicOptional.get();
				productService.increaseReadCount(findMusic);
				model.addAttribute("findMusic", findMusic);
				System.out.println(">>>MUSIC DETAIL:" + findMusic);

				model.addAttribute("replyList", replyList);
				System.out.println(">>>댓글정보:" + replyList);
			} else {
				model.addAttribute("errorMSG", "NOT FOUNT MUSIC");
			}
			return "product_music_detail";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG", "NOT FOUNT MUSIC" + e.getMessage());
			return "error";
		}
	}

	// 멤버십
	@LoginCheck
	@GetMapping("/product_membership_detail")
	public String MembershipDetail(HttpSession session, Model model) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);
			List<Product> memberships = productService.findByCategoryId(4L);
			System.out.println(">>>MEMBERSHIP LIST : " + memberships);

//			if(session.getAttribute("userId")!=null) {
//				return "product_membership_detail";
//			}else {
//				return "user_login_form";
//			}
			return "product_membership_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 굿즈리스트
	@LoginCheck
	@GetMapping("/product_goods_list")
	public String GoodsList(Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);
			List<ProductDto> goodsList = productService.findByProductCategoryId(2L);
			model.addAttribute("goodsList", goodsList);
			// System.out.println(">>>TICKET LIST : " + tickets);
			return "product_goods_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}

	}

	// 굿즈디테일
	@LoginCheck
	@GetMapping("/product_goods_detail")
	public String GoodsDetail(@RequestParam(name = "productNo") Long productNo, Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);
			Optional<Product> findGoodsOptional = productService.findByProductNo(productNo);
			List<ProductReply> ReplyList = productService.findByProduct_productNo(productNo);
			if (findGoodsOptional.isPresent()) {
				Product findGoods = findGoodsOptional.get();
				productService.increaseReadCount(findGoods);
				model.addAttribute("findGoods", findGoods);
				System.out.println(">>>굿즈 상세정보:" + findGoods);
				model.addAttribute("ReplyList", ReplyList);
				System.out.println(">>>댓글정보:" + ReplyList);
			} else {
				model.addAttribute("errorMSG", "해당 굿즈를 찾을 수 없습니다.");
			}
			return "product_goods_detail";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG", "티켓을 찾는 중 오류 발생: " + e.getMessage());
			return "error";
		}
	}

	// 티켓리스트
	@LoginCheck
	@GetMapping("/product_ticket_list")
	public String TicketList(Model model, HttpSession session) {
		try {
			String userId = (String) session.getAttribute("sUserId");
			model.addAttribute("userId", userId);
			List<ProductDto> tickets = productService.findByProductCategoryId(3L);
			tickets = productService.productByReadCountDescDto(3L);
			model.addAttribute("tickets", tickets);
			// System.out.println(">>>TICKET LIST : " + tickets);
			return "product_ticket_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}

	}

	// 티켓디테일
	@LoginCheck
	@GetMapping("/product_ticket_detail")
	public String TicketDetail(@RequestParam(name = "productNo") Long productNo, Model model, HttpSession session) {
		try {
			String loginUser = (String) session.getAttribute("sUserId");
			UserDto user = null;

			if (loginUser != null) {
				user = userService.findUser(loginUser);
			}

			session.setAttribute("loginUser", user);

			String userIdString = (user != null) ? user.getUserId() : null;
			model.addAttribute("userIdString", userIdString);

			Optional<Product> findTicketOptional = productService.findByProductNo(productNo);
			List<ProductReply> ReplyList = productService.findByProduct_productNo(productNo);
			if (findTicketOptional.isPresent()) {
				Product findTicket = findTicketOptional.get();
				productService.increaseReadCount(findTicket);
				model.addAttribute("findTicket", findTicket);
				System.out.println(">>>티켓 상세정보:" + findTicket);
				model.addAttribute("ReplyList", ReplyList);
				System.out.println(">>>댓글정보:" + ReplyList);
			} else {
				model.addAttribute("errorMSG", "해당 티켓을 찾을 수 없습니다.");
			}
			return "product_ticket_detail";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG", "티켓을 찾는 중 오류 발생: " + e.getMessage());
			return "error";
		}
	}

}
