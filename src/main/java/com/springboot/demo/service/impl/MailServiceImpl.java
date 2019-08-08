package com.springboot.demo.service.impl;

import com.springboot.demo.service.MailService;
import com.springboot.demo.util.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    SpringTemplateEngine springTemplateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        log.info("{} sendSimpleMail to {},subject:{},content:{}",from,to,subject,content);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        message.setSentDate(new Date());
        log.info("{} sendSimpleMail begin",from);
        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            log.warn("sendSimpleMail MailException:{}",e.getMessage());
        }
        log.info("{} sendSimpleMail finish",from);
    }

    @Override
    public void sendAttachmentMail(String to, String subject, String content, String imageName) {
        log.info("{} sendAttachmentMail to {},subject:{},content:{},fileName:{}",to,subject,content,imageName);
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setSentDate(new Date());

            ClassPathResource file = new ClassPathResource(Constant.IMAGE_PATH+imageName);
            helper.addAttachment(imageName,file);
        } catch (MessagingException e) {
            log.warn("sendAttachmentMail MessagingException : {}",e.getMessage());
        }

        log.info("{} sendAttachmentMail begin",from);
        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            log.warn("sendAttachmentMail MailException : {}", e.getMessage());
        }
        log.info("{} sendAttachmentMail finish", from);
    }

    @Override
    public void sendFileMail(String to, String subject, String content, String[] fileNames) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            helper.setSentDate(new Date());

            mimeMessage = helper.getMimeMessage();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(content, "text/html;charset=UTF-8");

            // 描述数据关系
            MimeMultipart mm = new MimeMultipart();
            mm.setSubType("related");
            mm.addBodyPart(mimeBodyPart);

            // 添加邮件附件
            for (String filename : fileNames) {
                MimeBodyPart attachPart = new MimeBodyPart();
                try {
                    attachPart.attachFile(filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mm.addBodyPart(attachPart);
            }
            mimeMessage.setContent(mm);
            mimeMessage.saveChanges();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);
    }

}
