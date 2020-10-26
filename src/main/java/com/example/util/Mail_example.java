package com.example.util;


import org.apache.commons.mail.HtmlEmail;

import java.util.Date;

public class Mail_example extends Thread {
    private final String email;
    private final String username;
    private final String password;


    public Mail_example(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }

    @Override
    public void run() {
        try {

            HtmlEmail mail = new HtmlEmail();
            // 设置邮箱服务器信息
            mail.setSslSmtpPort("25");
            mail.setHostName("smtp.163.com");
            // 设置密码验证器
            mail.setAuthentication("email", "password");
            // 设置邮件发送者
            mail.setFrom("email");
            // 设置邮件接收者
            mail.addTo(email);
            // 设置邮件编码
            mail.setCharset("UTF-8");
            // 设置邮件主题
            mail.setSubject("Tally");
            // 设置邮件内容
            mail.setHtmlMsg("<h1 style='color: red'>" + username + "注册成功 </h1>" + "请保存好密码:" + password);
            // 设置邮件发送时间
            mail.setSentDate(new Date());
            // 发送邮件
            mail.send();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
