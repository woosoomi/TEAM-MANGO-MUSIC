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

import com.itwill.jpa.controller.user.LoginCheck;
import com.itwill.jpa.dto.product.ProductDto;
import com.itwill.jpa.dto.product.ProductMusicDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.product.ProductServiceImpl;
import com.itwill.jpa.service.user.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ProductController2 {
	
	@Autowired
	private final ProductService productService;
	@Autowired
	private final UserService userService;
	
	// 뮤직리스트 
	@GetMapping("/music_list")
	public String musicList(Model model) {
		try {
			List<ProductDto> musics = productService.findByProductCategoryId(1L);
			model.addAttribute("musics", musics);
			//log.info(">>>MUSIC LIST : " + musics);
			return "music_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 뮤직디테일
	@GetMapping("/music_detail/{productNo}")
	public String MusicDetail(@RequestParam(value="productNo",required=false) Long productNo, Model model) {
		try {
			Optional<Product> musicOptional = productService.findByProductNo(productNo);
			
			if(musicOptional.isPresent()) {
				Product musicDetail=musicOptional.get();
				productService.increaseReadCount(musicDetail);
				model.addAttribute("musicDetail", musicDetail);
				log.info(">>>MUSIC DETAIL :"+  musicDetail);
			}else {
				throw new Exception("NOT FOUND MUSIC");
			}
			
			return "music_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}
	
	// 멤버십
	@GetMapping("/membership_detail")
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
			return "membership_detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 굿즈리스트
		@GetMapping("/goods_list")
		public String GoodsList(Model model) {
			try {
				List<ProductDto> goods = productService.findByProductCategoryId(2L);
				model.addAttribute("goods", goods);
				//System.out.println(">>>GOODS LIST : " + goods);
				return "goods_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
		
		}
		
		// 굿즈디테일
		@GetMapping("/goods_detail/{productNo}")
		public String GoodsDetail(@PathVariable Long productNo ,Model model) {
			try {
				Product goodsDetail=(Product)productService.findByProductNo(productNo).get();
				System.out.println(productNo);
				System.out.println(goodsDetail);
				
				productService.increaseReadCount(goodsDetail);
				model.addAttribute("goodsDetail", goodsDetail);
				log.info(">>>GOODS DETAIL : "+ goodsDetail);
				
				return "goods_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
	
		
		// 티켓리스트
		@GetMapping("/ticket_list")
		public String TicketList(Model model) {
			try {
				List<ProductDto> tickets = productService.findByProductCategoryId(3L);
				model.addAttribute("tickets", tickets);
				//System.out.println(">>>TICKET LIST : " + tickets);
				return "ticket_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 티켓디테일
		@GetMapping("/ticket_detail/{productNo}")
		public String TicketDetail(@PathVariable Long producNo , Model model) {
			try {
				Product ticketDetail = (Product) productService.findByProductNo(producNo).get();
				System.out.println(ticketDetail);
				
				productService.increaseReadCount(ticketDetail);
				model.addAttribute("ticketDetail", ticketDetail);
				log.info(">>>TICKET DETAIL : " + ticketDetail);
				return "ticket_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		

		
		
}
