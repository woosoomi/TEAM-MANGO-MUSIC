package com.itwill.jpa.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.dto.product.ProductMusicDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.repository.product.ProductRepository;
import com.itwill.jpa.service.product.ProductService;
import com.itwill.jpa.service.product.ProductServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController2 {
	@Autowired
	private final ProductServiceImpl productServiceImpl;
	
	@Autowired
	private ProductService productService;
	
	// 뮤직리스트 
	@GetMapping("/MusicList")
	public String musicList(Model model) {
		try {
			List<Product> musics = productServiceImpl.findByCategoryId(1L);
			model.addAttribute("musics", musics);
			System.out.println(">>>MUSIC LIST : " + musics);
			return "MusicList";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return "index";
		}
	}

	// 뮤직디테일
	@GetMapping("/MusicDetail")
	public String MusicDetail(Model model) {
		try {
			
			return "MusicDetail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return "index";
		}
	}
	
	// 멤버십
	@GetMapping("/MembershipDetail")
	public String MembershipDetail(Model model) {
		try {
			List<Product> memberships = productServiceImpl.findByCategoryId(4L);
			model.addAttribute("memberships", memberships);
			System.out.println(">>>MEMBERSHIP LIST : " + memberships);
			return "MembershipDetail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return "index";
		}
	}

	// 굿즈리스트
		@GetMapping("/GoodsList")
		public String GoodsList(Model model) {
			try {
				List<Product> goods = productServiceImpl.findByCategoryId(2L);
				model.addAttribute("goods", goods);
				System.out.println(">>>GOODS LIST : " + goods);
				return "GoodsList";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return "index";
			}
		
		}
		
		// 티켓리스트
		@GetMapping("/TicketList")
		public String TicketList(Model model) {
			try {
				List<Product> tickets = productServiceImpl.findByCategoryId(3L);
				model.addAttribute("tickets", tickets);
				System.out.println(">>>TICKET LIST : " + tickets);
				return "TicketList";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return "index";
			}
			
		}
		
		// 티켓디테일
		@GetMapping("/TicketDetail")
		public String TicketDetail(Model model) {
			try {
				
				return "TicketDetail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return "index";
			}
			
		}
		
		// 굿즈디테일
		@GetMapping("/GoodsDetail")
		public String GoodsDetail(Model model) {
			try {
				
				return "GoodsDetail";
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute(e.getMessage());
				return "index";
			}
			
		}
	
}
