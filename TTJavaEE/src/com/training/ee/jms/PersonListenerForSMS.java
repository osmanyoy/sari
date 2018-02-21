package com.training.ee.jms;

import java.io.Serializable;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.training.ee.ejb.PersonDAO;
import com.training.ee.model.Person;


@MessageDriven(activationConfig = { @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "PersonTopic"),
        @ActivationConfigProperty(propertyName = "destinationType",
                                  propertyValue = "javax.jms.Topic") })
public class PersonListenerForSMS implements MessageListener{
    
    @EJB
    private PersonDAO personDAO;
    
    @EJB
    private PersonStateBean psb;
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                PersonState personState = psb.getPersonState(textMessage.getText());
                if (personState != null) {
                    Person person = personState.getPerson();
                    try {
                        personState.setSmsState(EState.SUCCESS);
                    } catch (Exception e) {
                        personState.setSmsState(EState.FAILURE);
                    }
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

}
