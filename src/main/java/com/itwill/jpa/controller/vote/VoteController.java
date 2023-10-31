package com.itwill.jpa.controller.vote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.jpa.dto.product.ProductVoteDto;
import com.itwill.jpa.entity.product.Product;
import com.itwill.jpa.entity.vote.Vote;
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
    public String selectProduct(Long voteId, Model model) {
		try {
			Long a = 1L;  // 임의로 voteID 부여
			Vote vote = voteServiceImpl.selectByVoteNo(a);
			Product product = productVoteServiceImple.findByVoteVoteId(vote.getVoteId());
			ProductVoteDto productVote = ProductVoteDto.toDto(product);
			model.addAttribute("productWithVote", productVote);
			System.out.println("productWithVote"+productVote);
		
		
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorMSG : " + e.getMessage());			
			return null;
		}
        return "voteMain"; // 템플릿 이름 반환
    }
	*/
	
	@GetMapping("/productVote")
	public String selectProduct(Long voteId, Model model) {
	    try {
	        Long a = 1L;  // 임의로 voteID 부여
	        Vote vote = voteServiceImpl.selectByVoteNo(a);
	        
	        if (vote != null) {
	            Product product = productVoteServiceImple.findByVoteVoteId(vote.getVoteId());
	            
	            if (product != null) {
	                ProductVoteDto productVote = ProductVoteDto.toDto(product);
	                model.addAttribute("productVote", productVote);  
	                // 모델에 이름을 "productVote"로 변경
	                System.out.println("productVote: " + productVote);
	                return "voteMain";  // 템플릿 이름 반환
	            } else {
	                model.addAttribute("errorMSG", "Product not found.");
	            }
	        } else {
	            model.addAttribute("errorMSG", "Vote not found.");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("errorMSG", e.getMessage());
	    }
	    
	    // 오류가 발생했을 때 오류 페이지로 리다이렉션
	    return "errorPage";
	}
	
}
