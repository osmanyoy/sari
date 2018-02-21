package com.training.ee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "MyTopic"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Topic") })
public class TopicListener2 implements MessageListener{

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("TopicListener2 message : " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
