package com.training.client.wsclient;

import java.util.Map;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class WebSocketClient {
    
    @OnMessage
    public void message(Session session,String message) {
        System.out.println(message);
    }
    
    @OnError
    public void error(Session session,Throwable exception) {
        
    }
    
    @OnOpen
    public void open(Session session,EndpointConfig endpointConfig) {
        Map<String, Object> userProperties = session.getUserProperties();
        System.out.println(userProperties);
    }   
    
    @OnClose
    public void open(Session session,CloseReason closeReason) {
        System.out.println(closeReason);
    }

}
