package com.training.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions(value = {
        @JMSDestinationDefinition(name = "java:/jms/queue/JMSSampleQueue", 
        		destinationName = "JMSSampleQueue",
        		interfaceName="javax.jms.Queue") ,
        @JMSDestinationDefinition(name = "java:/jms/queue/JMSSampleTopic", 
        		destinationName = "JMSSampleTopic",
        		interfaceName="javax.jms.Topic") }
)

/**
 * Message-Driven Bean implementation class for: MessageListener
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSSampleQueue") })
public class MessageListenerTest implements MessageListener {

	/**
	 * Default constructor.
	 */
	public MessageListenerTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListenerTest#onMessage(Message)
	 */
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("Listener 1 :  " + textMessage.getText());
			} catch (Exception e) {
			}
		}
	}

}
