package com.springboot.demo.controller;

import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.service.UserService;
import com.springboot.demo.util.RedisUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    UserService userService;
    @Resource
    RedisUtil redisUtil;

    @PostMapping("/login")
    public Map<String,Object> login(String username,String password) {
        Map<String,Object> map = new HashMap<>();
        UserEntity user = userService.getUserByUserName(username);
        if(!user.getPassword().equals(password)) {
            map.put("message","密码错误");
            map.put("status","error");
            return map;
        }
        redisUtil.set(user.getId(),user);
        map.put("message","登录成功");
        map.put("status","accept");
        return map;
    }

}
