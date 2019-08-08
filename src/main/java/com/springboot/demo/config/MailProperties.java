package com.springboot.demo.config;

import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "mail")
public class MailProperties {
    /**
     * 邮箱服务器主机名
     *
     */
    private String host;
    /**
     * 邮箱服务器端口号
     */
    private Integer port = 25;
    /**
     * 邮箱用户名
     */
    private String username;
    /**
     * 邮箱第三方授权码
     */
    private String password;
    /**
     * 邮件传输协议
     * 默认smtp
     */
    private String protocol = "smtp";
    /**
     * 邮件编码UTF-8
     */
    private Charset charset = Charset.forName("UTF-8");

    private Map<String,String> properties;
    public MailProperties() {
        this.properties = new HashMap<>();
    }

}
