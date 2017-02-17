package com.forum.controller;

import java.util.Date;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.forum.model.*;

@Controller
@RequestMapping("/")
public class ChatController {

  @RequestMapping(method = RequestMethod.GET)
  public String viewApplication() {
    return "index";
  }
    
  @MessageMapping("/chat")
  @SendTo("/topic/message")
  public OutputMessage sendMessage(Message message) {
    return new OutputMessage(message, new Date());
  }
}
