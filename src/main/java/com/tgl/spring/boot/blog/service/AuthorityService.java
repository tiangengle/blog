package com.tgl.spring.boot.blog.service;

import com.tgl.spring.boot.blog.entity.Authority;

public interface AuthorityService {
    /**
     * 根据 id 查询权限
     * @param id
     * @return
     */
    Authority getAuthorityById(Long id);
}
