package com.liujiang.shop.service;

import com.liujiang.shop.dao.UserMapper;
import com.liujiang.shop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean login(String name, String password) {
        System.out.println(name+"===="+password);
        User u = userMapper.login(name, password);
        if (u!=null){
            return  true;
        }
        return false;
    }
}
