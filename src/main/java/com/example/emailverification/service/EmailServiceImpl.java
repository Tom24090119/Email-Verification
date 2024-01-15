package com.example.emailverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(String userEmail, String uuid){

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(userEmail);
        simpleMailMessage.setSubject("Email Verification");
        simpleMailMessage.setText("http://localhost:8080/"+uuid);

        sender.send(simpleMailMessage);
    }
}
