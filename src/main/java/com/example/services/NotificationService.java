package com.example.services;
import com.example.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
@Service
public class NotificationService {
    
    private JavaMailSenderImpl emailSender;

    @Autowired
    public void NotificationService(JavaMailSenderImpl javaMailSender){
        this.emailSender = emailSender;

    }
    public void sendNotification(UserModel user){
        SimpleMailMessage mail = new SimpleMailMessage();
    }

    
}
