package com.example.messagingstompwebsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller //msg STOMP são roteadas a essa assinatura (spring)
public class GreetingController {
    
    @MessageMapping("/hello")//Assegura se uma msg for enviada pra '/hello', o métoddo 'greeting()' é chamado
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception{
        
        //No 'message' está a mensagem que iremos usar 
        Thread.sleep(1000); //simulated delay
        return new Greeting("Hello, "+HtmlUtils.htmlEscape(message.getName())
        +"!");
        //Retorna o valor para todos os assinantes de '/topic/greeting'. Tudo por causa do @SendTo
    }

}