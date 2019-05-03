package com.collab.Controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import com.collab.Model.Message;
import com.collab.Model.OutputMessage;

@RestController
public class ChatController 
{
	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendmessage(Message message)
	{
		return new OutputMessage(message,new Date());
	}

}
