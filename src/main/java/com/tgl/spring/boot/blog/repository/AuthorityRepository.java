package com.tgl.spring.boot.blog.repository;

import com.tgl.spring.boot.blog.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 权限仓库
 */
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
