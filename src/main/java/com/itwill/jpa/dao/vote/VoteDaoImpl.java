package com.itwill.jpa.dao.vote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itwill.jpa.dto.vote.VoteDto;
import com.itwill.jpa.entity.vote.Vote;
import com.itwill.jpa.repository.vote.VoteRepository;

public class VoteDaoImpl implements VoteDao{
	
	@Autowired
	VoteRepository voteRepository;

	@Override
	public Vote createVote(Vote vote) throws Exception {
		Vote createVote = voteRepository.save(vote);
		return createVote;
		
		
	}

	@Override
	public int voteUserforArtist(VoteDto userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeVoteArtist(VoteDto artist) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VoteDto findVoteArtist() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoteDto> findVoteArtistList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VoteDto> findVoteUserId() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
	
}
