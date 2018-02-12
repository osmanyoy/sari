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
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSSampleTopic") })
public class MessageListenerTopicTest1 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public MessageListenerTopicTest1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListenerTopicTest1#onMessage(Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Listener Topic 1 :  " + textMessage.getText());
			} catch (Exception e) {
			}
		}
	}

}
