package com.itwill.jpa.repository.vote;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;



public interface VoteRepository extends JpaRepository<Vote, Long>{

}
