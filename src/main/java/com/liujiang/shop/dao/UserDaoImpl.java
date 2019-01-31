package com.liujiang.shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public boolean login(String name, String password) {
        if ("admin".equals(name) && "123".equals(password)){
            return true;
        }
        return false;
    }
}
