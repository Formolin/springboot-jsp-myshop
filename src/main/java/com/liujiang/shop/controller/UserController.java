package com.liujiang.shop.controller;

import com.liujiang.shop.service.UserService;
import com.liujiang.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //访问login.jsp
    @RequestMapping("/")
    public String loginIndex() {
        return "login";
    }

    //    登录方法
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        boolean login = userService.login(username, password);
        if (login) {
            System.out.println("成功");
            return "index";
        } else {
            System.out.println("defate");
            return "login";
        }
    }
}
