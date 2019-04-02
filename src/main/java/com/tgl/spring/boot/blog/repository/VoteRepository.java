package com.tgl.spring.boot.blog.repository;

import com.tgl.spring.boot.blog.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Vote 仓库.
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {
 
}
