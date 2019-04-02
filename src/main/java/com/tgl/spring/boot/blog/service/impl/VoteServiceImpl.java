package com.tgl.spring.boot.blog.service.impl;

import javax.transaction.Transactional;

import com.tgl.spring.boot.blog.entity.Vote;
import com.tgl.spring.boot.blog.repository.VoteRepository;
import com.tgl.spring.boot.blog.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Vote 服务实现.
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;

	@Override
	@Transactional
	public void removeVote(Long id) {
		voteRepository.delete(id);
	}

	@Override
	public Vote getVoteById(Long id) {
		return voteRepository.findOne(id);
	}

}
