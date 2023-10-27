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
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return "index";
		}
		return "MusicDetail";
	}
	
	// 멤버십
	@GetMapping("/MembershipDetail")
	public String MembershipDetail(Model model) {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(e.getMessage());
			return "index";
		}
		return "MembershipDetail";
	}

	
	
}
