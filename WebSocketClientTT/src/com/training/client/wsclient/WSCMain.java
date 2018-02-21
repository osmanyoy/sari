package com.training.client.wsclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WSCMain {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("ws://127.0.0.1:8080/TTJavaEE/wspath");
        WebSocketContainer socketContainer = ContainerProvider.getWebSocketContainer();
        Session session = socketContainer.connectToServer(WebSocketClient.class, uri);
        
        Scanner scanner = new Scanner(System.in);
        String str = null;
        while((str = scanner.nextLine()) != null) {
            if (str.equals("exit")) {
                break;
            }
            session.getAsyncRemote().sendText(str);
        }
    }
}
