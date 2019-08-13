package com.springboot.demo.dao;

import com.springboot.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    void addUser(UserEntity userEntity);
    void updateUser(UserEntity userEntity);
    void deletedUser(UserEntity userEntity);
    UserEntity selectUserById(String userId);
    UserEntity selectUserByUserName(String userName);
}
