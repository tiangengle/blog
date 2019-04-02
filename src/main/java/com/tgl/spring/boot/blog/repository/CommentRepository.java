package com.tgl.spring.boot.blog.repository;


import com.tgl.spring.boot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Comment 仓库.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
 
}
