package com.tgl.spring.boot.blog.service.impl;

import javax.transaction.Transactional;

import com.tgl.spring.boot.blog.entity.Comment;
import com.tgl.spring.boot.blog.repository.CommentRepository;
import com.tgl.spring.boot.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comment 服务实现.
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	@Transactional
	public void removeComment(Long id) {
		commentRepository.delete(id);
	}

	@Override
	public Comment getCommentById(Long id) {
		return commentRepository.findOne(id);
	}

}
