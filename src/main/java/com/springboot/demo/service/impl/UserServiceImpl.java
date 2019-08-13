package com.springboot.demo.service.impl;

import com.springboot.demo.dao.UserDao;
import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public boolean addUser(UserEntity userEntity) {
        if(userEntity==null)
            return false;
        userDao.addUser(userEntity);
        return true;
    }

    @Override
    public boolean updateUser(UserEntity userEntity) {
        if(userEntity==null)
            return false;
        userDao.updateUser(userEntity);
        return true;
    }

    @Override
    public boolean deletedUser(UserEntity userEntity) {
        if(userEntity==null)
            return false;
        userDao.deletedUser(userEntity);
        return true;
    }

    @Override
    public UserEntity getUserById(String userId) {
        if(userId==null || userId.equals(""))
            return null;
        return userDao.selectUserById(userId);
    }

    @Override
    public UserEntity getUserByUserName(String userName) {
        if(userName==null || userName.equals(""))
            return null;
        return userDao.selectUserByUserName(userName);
    }
}
