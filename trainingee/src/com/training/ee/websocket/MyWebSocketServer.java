package com.training.ee.websocket;

import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/msg")
public class MyWebSocketServer {

	@OnMessage
	public void onMessage(final Session session, final String message) {
		System.out.println("Message recieved : " + message);
		session.getAsyncRemote()
		       .sendText("test message : " + message);
	}

	@OnError
	public void onError(final Session session, final Throwable throwable) {
	}

	@OnOpen
	public void onOpen(final Session session, final EndpointConfig endpointConfig) {
		System.out.println("Connection Open");
	}

	@OnClose
	public void onClose(final Session session, final CloseReason closeReason) {
		System.out.println("Connection Close");
	}

}
