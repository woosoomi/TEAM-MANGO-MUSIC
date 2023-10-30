package com.itwill.jpa.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.controller.user.LoginCheck;
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
	private final ProductServiceImpl productServiceImpl;
	
	@Autowired
	private final ProductService productService;
	@Autowired
	private final UserService userService;
	
	// 뮤직리스트 
	@GetMapping("/music_list")
	public String musicList(Model model,HttpSession session) {
		try {
			List<Product> musics = productServiceImpl.findByCategoryId(1L);
			model.addAttribute("musics", musics);
			System.out.println(">>>MUSIC LIST : " + musics);
			return "music_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return null;
		}
	}

	// 뮤직디테일
	@GetMapping("/music_detail{productNo}")
	public String MusicDetail(@PathVariable Long productNo, Model model) {
		try {
			Product products = (Product) productService.findByProductNo(productNo).get();
			productService.increaseReadCount(products);
			
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
			List<Product> memberships = productServiceImpl.findByCategoryId(4L);
			if(session.getAttribute("")!=null) {
				//user로 멤버십 구매 찾기?
				
				
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
				List<Product> goods = productServiceImpl.findByCategoryId(2L);
				model.addAttribute("goods", goods);
				System.out.println(">>>GOODS LIST : " + goods);
				return "goods_list";
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
				List<Product> tickets = productServiceImpl.findByCategoryId(3L);
				model.addAttribute("tickets", tickets);
				System.out.println(">>>TICKET LIST : " + tickets);
				return "ticket_list";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 티켓디테일
		@GetMapping("/ticket_detail")
		public String TicketDetail(Model model) {
			try {
				
				return "ticket_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
		
		// 굿즈디테일
		@GetMapping("/goods_detail")
		public String GoodsDetail(Model model) {
			try {
				
				return "goods_detail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return null;
			}
			
		}
	
}
