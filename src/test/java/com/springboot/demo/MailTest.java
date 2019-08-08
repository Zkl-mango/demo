package com.springboot.demo;

import com.springboot.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    MailService mailService;

    private String to = "1473055523@qq.com";

    @Test
    public void sendSimpleMail() {
        String subject="ppppppp";
        String content="testing";
        mailService.sendSimpleMail(to,subject,content);
        System.out.println("send to "+to+ "finish");
    }
}
