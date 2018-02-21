package com.training.ee.jms;

import java.util.UUID;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.training.ee.model.Person;

@Path("/jms")
public class JMSRest {
    
    @EJB
    private PersonStateBean psb;
    
    @Inject
    private JMSContext jmsContext;
    
    @Resource(lookup="java:/jms/queue/MyQueue")
    private Queue queue;
    
    @Resource(lookup="java:/jms/queue/MyTopic")
    private Topic topic;

    @Resource(lookup="java:/jms/queue/PersonTopic")
    private Topic ptopic;

    @GET
    public String sendMessage() {
        jmsContext.createProducer().send(queue, "Hello from rest");
        System.out.println("Sender Thread : " + Thread.currentThread().getName());
        return "OK";
    }
    
    @GET
    @Path("/topic")
    public String sendMessage2() {
        jmsContext.createProducer().send(topic, "Hello topic");
        return "OK";
    }
    
    @POST
    @Path("/person")
    public String processPerson(Person person) {
        
        PersonState personState = new PersonState();
        personState.setPerson(person);
        String uid = UUID.randomUUID().toString();
        personState.setId(uid);
        psb.writePersonState(personState);
        jmsContext.createProducer().send(ptopic, uid);
        return uid;
    }
    
    @GET
    @Path("/personQuery")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonState processPerson(@QueryParam("id") String id) {
        PersonState personState = psb.getPersonState(id);
        return personState;
    }

}
