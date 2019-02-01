package com.liujiang.shop.controller;

import com.liujiang.shop.service.UserService;
import com.liujiang.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //访问login.jsp
    @RequestMapping("/")
    public String loginIndex(HttpServletRequest request, HttpServletResponse response) {
        //自动登录的代码
//        if(request.getCookies()!=null){
//            Cookie[] cookies = request.getCookies();
//            for(Cookie cookie:cookies){
//                if(cookie.getValue().equals("on")){
//                    return "index";
//                }
//            }
//        }
        return "login";
    }

    //    登录方法
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remeberme = request.getParameter("remeberme");
        String autologin = request.getParameter("autologin");
        if("on".equals(autologin)){
            //如果选中自动登录，添加到cookie
            Cookie auto = new Cookie("autologin",autologin);
            auto.setMaxAge(1000*60*60);
            response.addCookie(auto);

        }
        boolean login = userService.login(username, password);
        if (login) {
            System.out.println("成功");
            if ("on".equals(remeberme)){
//                创建cookie
                Cookie usernameCookie = new Cookie("usernameremeber",URLDecoder.decode(username,"utf-8"));
                Cookie passwordCookie = new Cookie("passwordremeber",URLDecoder.decode(password,"utf-8"));
                usernameCookie.setMaxAge(1000*60*60*24);
                passwordCookie.setMaxAge(1000*60*60*24);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                Cookie check = new Cookie("check","checked");
                check.setMaxAge(1000*60*60*24);
                response.addCookie(check);
            }
            response.sendRedirect("jsp/index.jsp");//加不加/都行
        } else {
            System.out.println("defate");
            request.setAttribute("error","用户名密码错误");
            return "login";
        }
        return null;
    }
}
