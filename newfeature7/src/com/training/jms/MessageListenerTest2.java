package com.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * Message-Driven Bean implementation class for: MessageListener
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSSampleQueue") })
public class MessageListenerTest2 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public MessageListenerTest2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListenerTest2#onMessage(Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Listener 2 :  " + textMessage.getText());
			} catch (Exception e) {
			}
		}
	}

}
