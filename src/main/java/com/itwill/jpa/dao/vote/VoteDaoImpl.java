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
	public Vote voteUserforArtist(Vote voteNo) throws Exception {
		Vote voteNouserForArtist = voteRepository.save(voteNo);
		return voteNouserForArtist;
	}

	@Override
	public Vote removeVoteArtist(Vote voteNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
