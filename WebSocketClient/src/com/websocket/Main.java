package com.websocket;

import java.net.URI;
import java.util.Scanner;

import javax.websocket.ContainerProvider;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class Main {

	public static void main(final String[] args) throws Exception {
		URI uri = new URI("ws://127.0.0.1:8080/trainingee/msg");
		WebSocketContainer socketContainer = ContainerProvider.getWebSocketContainer();
		Session session = socketContainer.connectToServer(MyWebSocketClient.class,
		                                                  uri);
		Scanner scanner = new Scanner(System.in);

		String nextLine = null;

		while (!(nextLine = scanner.nextLine()).equals("exit")) {
			session.getAsyncRemote()
			       .sendText(nextLine);
		}
		scanner.close();
	}

}
