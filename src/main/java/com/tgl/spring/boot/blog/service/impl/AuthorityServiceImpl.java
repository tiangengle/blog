package com.tgl.spring.boot.blog.service.impl;

import com.tgl.spring.boot.blog.entity.Authority;
import com.tgl.spring.boot.blog.repository.AuthorityRepository;
import com.tgl.spring.boot.blog.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 权限服务
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}
