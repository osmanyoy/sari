package com.training.ee.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions({ @JMSDestinationDefinition(name = "java:/jms/queue/JMSMyTopic", destinationName = "JMSMyTopic", interfaceName = "javax.jms.Topic") })

@MessageDriven(activationConfig = {

                                    @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSMyTopic"),
                                    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic") }, mappedName = "JMSMyTopic")
public class TopicListener1 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public TopicListener1() {
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
