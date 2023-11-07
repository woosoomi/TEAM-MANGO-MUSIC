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
import com.itwill.jpa.dto.product.ProductDto;

import com.itwill.jpa.entity.board.Board;
//import com.itwill.jpa.dto.product.ProductMusicDto;

import com.itwill.jpa.entity.product.Product;
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
	private final ProductServiceImpl productServiceImpl;
	
	@Autowired
	private final UserService userService;
	
	// 뮤직리스트 
	@GetMapping("/product_music_list")
	public String musicList(Model model) {
		try {
			List<ProductDto> musics = productService.findByProductCategoryId(1L);
			model.addAttribute("musics", musics);
			//log.info(">>>MUSIC LIST : " + musics);
			return "product_music_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 뮤직디테일 -> https://www.baeldung.com/spring-mvc-404-error
	
	@GetMapping("/product_music_detail")
	public String MusicDetail(@RequestParam(name = "productNo" ) Long productNo, Model model) {
		try {
			Optional<Product> findMusicOptional = productService.findByProductNo(productNo);
			
			System.out.println(findMusicOptional.get());
			
			if(findMusicOptional.isPresent()) {
				Product findMusic=findMusicOptional.get();
				productService.increaseReadCount(findMusic);
				model.addAttribute("findMusic", findMusic);
	            System.out.println(">>>MUSIC DETAIL:"+findMusic);
			}else {
				 model.addAttribute("errorMSG", "NOT FOUNT MUSIC");
			}
			return "product_music_detail";
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG","NOT FOUNT MUSIC"+e.getMessage());
			return "error";
		}
	}
	
	// 멤버십
	@GetMapping("/product_membership_detail")
	public String MembershipDetail(HttpSession session,Model model) {
		try {
			List<Product> memberships = productService.findByCategoryId(4L);
			if(session.getAttribute("")!=null) {
				//유저의 멤버십 구매 확인 - 오더, 유저 기능 구현된 거 확인하고 활용
				//구매가 되어있을 경우 메세지와 함께 뮤직 리스트로 넘겨버리는 간단한 액션
				
				//	or 레스트 활용 - (유저) 님은 멤버십 가입이 되어있습니다. 로 h2 체인지 -> 추후...시간 남으면 구현.
				
			}else {
				model.addAttribute("memberships", memberships);
			}
			System.out.println(">>>MEMBERSHIP LIST : " + memberships);
			return "product_membership_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 굿즈리스트
		@GetMapping("/product_goods_list")
		public String GoodsList(Model model) {
			try {
				List<ProductDto> goodsList = productService.findByProductCategoryId(2L);
				model.addAttribute("goodsList", goodsList);
				//System.out.println(">>>TICKET LIST : " + tickets);
				return "product_goods_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 굿즈디테일
		@GetMapping("/product_goods_detail")
		public String GoodsDetail(@RequestParam(name = "productNo") Long productNo ,Model model) {
		    try {
		        Optional<Product> findGoodsOptional = productService.findByProductNo(productNo);

		        if (findGoodsOptional.isPresent()) {
		            Product findGoods = findGoodsOptional.get();
		            productService.increaseReadCount(findGoods);
		            model.addAttribute("findGoods", findGoods);
		            System.out.println(">>>굿즈 상세정보:" + findGoods);
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
		@GetMapping("/product_ticket_list")
		public String TicketList(Model model) {
			try {
				List<ProductDto> tickets = productService.findByProductCategoryId(3L);
				model.addAttribute("tickets", tickets);
				//System.out.println(">>>TICKET LIST : " + tickets);
				return "product_ticket_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}

		// 티켓디테일
		@GetMapping("/product_ticket_detail")
		public String TicketDetail(@RequestParam(name = "productNo") Long productNo, Model model) {
		    try {
		        Optional<Product> findTicketOptional = productService.findByProductNo(productNo);

		        if (findTicketOptional.isPresent()) {
		            Product findTicket = findTicketOptional.get();
		            productService.increaseReadCount(findTicket);
		            model.addAttribute("findTicket", findTicket);
		            System.out.println(">>>티켓 상세정보:" + findTicket);
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
