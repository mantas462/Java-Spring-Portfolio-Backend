package com.example.demo.sender;

import lombok.Data;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Data
public class MessageSender {


    public void sendMessage(com.example.demo.entity.Message sendedMessage) {
        Properties props = new Properties();
        props.put("mail.smtp.host" , "smtp.gmail.com");
        props.put("mail.stmp.user" , "username");

        //To use TLS
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.password", "password");
        //To use SSL
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "****MYEMAIL*****", "********MYPASSWORD******");// Specify the Username and the PassWord
                    }
                });
        String to = "****MYEMAIL*****";
        String from = "****MYEMAIL*****";
        String subject = "PORTFOLIO MESSAGE";
        javax.mail.Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            msg.setSubject(subject);
            msg.setText(sendedMessage.getSenderMessage() + "\n\nSENDED FROM - " + sendedMessage.getSenderName() + ", EMAIL - " + sendedMessage.getSenderEmail());
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com" , 465 , "****MYEMAIL*****", "********MYPASSWORD******");
            transport.send(msg);
            System.out.println("fine!!");
        }
        catch(Exception exc) {
            System.out.println(exc);
        }
    }





}
