package com.example.demo.entity;

import lombok.Data;
import org.springframework.context.annotation.Bean;

@Data
public class Message {

    private String senderName;

    private String senderEmail;

    private String senderMessage;

    public Message() {
    }

    public Message(String senderName, String senderEmail, String senderMessage) {
        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.senderMessage = senderMessage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    public void setSenderMessage(String senderMessage) {
        this.senderMessage = senderMessage;
    }
}
