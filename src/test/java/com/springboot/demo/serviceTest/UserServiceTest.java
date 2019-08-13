package com.springboot.demo.serviceTest;

import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.service.UserService;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void addTest() {
        UserEntity user = new UserEntity();
        user.setId("222");
        user.setNickname("ooo");
        user.setPassword("123456");
        user.setUsername("hhhhhhhhh");
        userService.addUser(user);
    }

    @Test
    public void updateTest() {
        UserEntity user = userService.getUserById("222");
        user.setNickname("lll");
        userService.updateUser(user);
        UserEntity userEntity = userService.getUserByUserName("hhhhhhhhh");
        System.out.println(userEntity);
    }


}
