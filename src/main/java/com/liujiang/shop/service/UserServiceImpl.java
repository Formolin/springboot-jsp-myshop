package com.liujiang.shop.service;

import com.liujiang.shop.dao.UserDao;
import com.liujiang.shop.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public boolean login(String name, String password) {
        boolean login = userDao.login(name, password);
        if (login){
            return  true;
        }
        return false;
    }
}
