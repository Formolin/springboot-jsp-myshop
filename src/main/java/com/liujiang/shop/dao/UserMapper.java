package com.liujiang.shop.dao;

import com.liujiang.shop.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("select * from user where username = #{name} and password=#{passowrd}")
    public User login(@Param("name") String name, @Param("passowrd") String password);
    //查询用户user表
    @Select("select * form user")
    public List<User> findAllUser();
}
