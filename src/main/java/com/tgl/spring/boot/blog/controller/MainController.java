package com.tgl.spring.boot.blog.controller;

import com.tgl.spring.boot.blog.entity.Authority;
import com.tgl.spring.boot.blog.entity.User;
import com.tgl.spring.boot.blog.service.AuthorityService;
import com.tgl.spring.boot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 主页控制器
 */
@Controller
public class MainController {

    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;

    @GetMapping("/")
    public String root(){
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(){
        return "redirect:/blogs";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        model.addAttribute("errorMsg","登录失败，用户名或密码错误！");
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    /**
     * 注册用户
     * @param user
     */
    @PostMapping("/register")
    public String registerUser(User user) {

        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);

        userService.saveOrUpdateUser(user);
        return "redirect:/login";
    }
}