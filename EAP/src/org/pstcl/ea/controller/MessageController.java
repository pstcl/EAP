package org.pstcl.ea.controller;

import java.util.Date;

import org.pstcl.ea.messaging.Message;
import org.pstcl.ea.messaging.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MessageController {


	@GetMapping("/socket")
	public String socket(Model model)
	{



		return "socket";
	}

	@Autowired
	private SimpMessagingTemplate template;

	@MessageMapping("/hello")
	@SendTo("/topic/messages")
	public void send(Message message) throws Exception{
		System.out.println("Inside chat send");
		for (int i = 0; i < 10; i++) {

			Thread.currentThread().sleep(5*1000);
			OutputMessage msg= new OutputMessage("hello "+i+" !!!!");
			template.convertAndSend("/topic/messages",msg);
		}
	}

	@GetMapping("/hello2")
	@SendTo("/topic/messages")
	public void hello() throws Exception{
		System.out.println("Inside chat send");
		for (int i = 0; i < 10; i++) {
			System.out.println("hello2"+i);
			Thread.currentThread().sleep(5*1000);
			OutputMessage msg= new OutputMessage("hello "+i+" !!!!");
			template.convertAndSend("/topic/messages",msg);
		}
	}




}
