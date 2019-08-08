package com.springboot.demo.service;

public interface MailService {

    /**
     * 发送普通邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleMail(String to, String subject, String content);

    void sendAttachmentMail(String to, String subject, String content, String imageName);

    void sendFileMail(String to, String subject, String content, String[] fileNames);

}
