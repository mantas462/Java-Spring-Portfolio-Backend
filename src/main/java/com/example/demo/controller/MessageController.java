package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.sender.MessageSender;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan
@RestController
@RequestMapping("/api")
@CrossOrigin("www.mantasnacickas.com")
public class MessageController {


    @PostMapping("/sendmessage" )
    public Message sendMessage(@RequestBody Message message) {

        MessageSender messageSender=new MessageSender();
        messageSender.sendMessage(message);

        return message;
    }

}
