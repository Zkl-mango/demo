package com.springboot.demo.service;


import com.springboot.demo.entity.UserEntity;

public interface UserService {

    boolean addUser(UserEntity userEntity);
    boolean updateUser(UserEntity userEntity);
    boolean deletedUser(UserEntity userEntity);
    UserEntity getUserById(String userId);
    UserEntity getUserByUserName(String userName);

}
