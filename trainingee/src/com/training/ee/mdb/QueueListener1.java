package com.training.ee.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions({ @JMSDestinationDefinition(name = "java:/jms/queue/JMSMyQueue", destinationName = "JMSMyQueue", interfaceName = "javax.jms.Queue") })

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSMyQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "JMSMyQueue")
public class QueueListener1 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public QueueListener1() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	@Override
	public void onMessage(final Message message) {

		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				String text = textMessage.getText();
				System.out.println(text);
			} catch (Exception e) {
			}
		}

	}

}
