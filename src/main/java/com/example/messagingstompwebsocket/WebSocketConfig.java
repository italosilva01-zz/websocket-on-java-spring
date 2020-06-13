package com.example.messagingstompwebsocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration//indica para o spring que é uma classe de configuração
@EnableWebSocketMessageBroker//Permite o tratamento de mensagens do Websocket   
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //Configura o intermediario padrão das mensagens
        
        config.enableSimpleBroker("/topic");//permite levar as mensagens de volta pra os clientes em destinos prefixados com '/topic'

        config.setApplicationDestinationPrefixes("/app");//Configure um ou mais prefixos para filtrar destinos direcionados aos métodos anotados do aplicativo  

    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // TODO Auto-generated method stub
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}