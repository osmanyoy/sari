package com.training.ee.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination", propertyValue = "JMSMyQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") }, mappedName = "JMSMyQueue")
public class QueueListener2 implements MessageListener {

	/**
	 * Default constructor.
	 */
	public QueueListener2() {
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
				System.out.println("Listener 2 : " + text);
			} catch (Exception e) {
			}
		}

	}

}
