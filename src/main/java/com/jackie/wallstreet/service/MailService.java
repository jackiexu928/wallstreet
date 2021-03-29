package com.jackie.wallstreet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2021/3/25
 */
@Component
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void sendSimpleMail(String to, String subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        //message.setTo(to);
        message.setSubject(subject);
        message.setText(content);
        if (to.contains(";")){
            String[] tos = to.split(";");
            Arrays.stream(tos).forEach(toAddress -> {
                message.setTo(toAddress);
                javaMailSender.send(message);
            });
        }
    }
}
