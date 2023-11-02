package com.itwill.jpa.controller.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.dao.product.ProductVoteDaoImpl;
import com.itwill.jpa.dto.product.ProductVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.service.product.ProductVoteServiceImple;
import com.itwill.jpa.service.vote.VoteServiceImpl;

import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class VoteController {
	@Autowired
	private VoteServiceImpl voteServiceImpl;
	
	@Autowired
	private ProductVoteServiceImple productVoteServiceImple;
	
	
	@Autowired
	private ProductVoteDaoImpl productVoteDaoImpl;
	/*
	@GetMapping(value = "/voteMain")
	public String vote_html() {
		return "voteMain";
	}
	*/
	
	
	@GetMapping(value = "/voteMain")
	public String voteMain(Model model) {		
		return "voteMain";
	}
		
	/*
	@GetMapping("/productVote")
	public String ProductVoteList(Model model) {
		List<Product> product = productVoteServiceImple.findProductsByVoteIsNotNull();
		List<ProductVoteDto> productVote = ProductVoteDto.toDto(product);
		
		
		int totalVotes = 0; // 전체 투표 합

		for (ProductVoteDto dto : productVote) {
		    totalVotes += dto.getVoteTot();
		}
		
		model.addAttribute("productVote", productVote);  
		model.addAttribute("totalVotes", totalVotes);// 투표 합계
		
		System.out.println("productVote: " + productVote);
	        

	    return "voteMain";  // 템플릿 이름 반환
	}
	*/
	
	@GetMapping("/productVote")
	public String ProductVoteList(Model model) {
		List<ProductVoteDto> productVote = productVoteDaoImpl.findProductsByVoteIsNotNullOrderByVoteTotDesc();
		
		ProductVoteDto top1Product = productVote.get(0);
		ProductVoteDto top2Product = productVote.get(1);
		int totalVotes = 0; // 전체 투표 합

		for (ProductVoteDto dto : productVote) {
		    totalVotes += dto.getVoteTot();
		}
		
		model.addAttribute("top1Product", top1Product); // 1위
		model.addAttribute("top2Product", top2Product); // 2위
		model.addAttribute("productVote", productVote);  
		model.addAttribute("totalVotes", totalVotes);	// 투표 합계
		
		System.out.println("productVote: " + productVote);
	        

	    return "voteMain";  // 템플릿 이름 반환
	}


	
	
}
