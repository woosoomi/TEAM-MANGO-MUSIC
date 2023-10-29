package com.itwill.jpa.dto.user;

import com.itwill.jpa.entity.user.User;
import com.itwill.jpa.entity.vote.Vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserVoteDto {	 
	private Vote vote;
	
	public static UserVoteDto toDto(User entity) {
		return UserVoteDto.builder()
						  .vote(entity.getVote())
  						  .build();
	}
}
