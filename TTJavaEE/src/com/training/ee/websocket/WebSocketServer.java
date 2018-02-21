package com.training.ee.websocket;

import java.util.Map;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/wspath")
public class WebSocketServer {

    @OnMessage
    public void message(Session session,String message) {
        session.getAsyncRemote().sendText(message + "_received");
    }
    
    @OnError
    public void error(Session session,Throwable exception) {
        
    }
    
    @OnOpen
    public void open(Session session,EndpointConfig endpointConfig) {
        MyThread myThread = new MyThread(session);
        myThread.start();
        Map<String, Object> userProperties = session.getUserProperties();
        System.out.println(userProperties);
    }   
    
    @OnClose
    public void open(Session session,CloseReason closeReason) {
        System.out.println(closeReason);
    }
    
    public static class MyThread extends Thread{
        private Session mySession;
        
        private int counter = 0;
        public MyThread(Session mySession) {
            super();
            this.mySession = mySession;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5_000);
                    mySession.getAsyncRemote().sendText("message " + counter++);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
            }
        }
        
    }
    
}
