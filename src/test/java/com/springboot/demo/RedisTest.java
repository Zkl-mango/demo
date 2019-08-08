package com.springboot.demo;


import com.springboot.demo.entity.UserEntity;
import com.springboot.demo.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

//    @Resource
//    StringRedisTemplate stringRedisTemplate;
//    @Resource
//    RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void valueAddRedis() {
//        stringRedisTemplate.opsForValue().set("1","1");
//        stringRedisTemplate.opsForHash().put("126","a","99");
//        stringRedisTemplate.opsForHash().put("126","o","99o");
//        redisTemplate.opsForValue().set(1,1);
    }

    @Test
    public void valueGetResitTest() {
        UserEntity user = new UserEntity();
        user.setId("ee");
        user.setNickname("heee");
        user.setPassword("ppp");
        user.setUsername("ppooooo");
        redisUtil.set("user1",user);
        System.out.println(redisUtil.get("user1"));
//        String value = stringRedisTemplate.opsForValue().get("1");
//        System.out.println(value);
//        Map<Object,Object> map = stringRedisTemplate.opsForHash().entries("126");
//        // 获得map的key集合
//        Set<Object> objects =  stringRedisTemplate.opsForHash().keys("126");
//        for(int i=0;i<objects.size();i++) {
//            System.out.println(objects);
//        }
//        // 获得map的value列表
//        List<Object> list = stringRedisTemplate.opsForHash().values("126");
//        for(int i=0;i<list.size();i++) {
//            System.out.println(list.get(i));
//        }
//        long size =  stringRedisTemplate.opsForHash().size("126");
//        System.out.println("size:"+size);
//
//        int v = (int)redisTemplate.opsForValue().get(1);
//        System.out.println(v);
    }

    @Test
    public void hashGetDeleteResitTest() {
//        stringRedisTemplate.opsForHash().delete("126","o");
    }

}
