package com.notification.controller;

import com.notification.domain.User;
import com.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping("/signup")
    public String signup(){
        return "Please signup for our service";
    }

    @RequestMapping("/signup-success")
    public String signupSuccess(){

        User user = new User();
        user.setFirstName("Anshul");
        user.setLastName("Sharma");
        user.setEmailAddress("trenclobrand@gmail.com");

        try{
            notificationService.sendNotification(user);
        }catch (MailException e){

        }

        return "Thanks for registering with us!";
    }

}
