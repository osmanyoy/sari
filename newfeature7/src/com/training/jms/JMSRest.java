package com.training.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/jms")
public class JMSRest {
	
	@Inject
	private JMSContext jmsContext;
	
	@Resource(lookup="java:/jms/queue/JMSSampleQueue")
	private Queue queue;
	
	@Resource(lookup="java:/jms/queue/JMSSampleTopic")
	private Topic topic;

	@GET
	public String sendMessage() {
		jmsContext.createProducer().send(queue, "Hello");
		return "OK";
	}
	
	@GET
	@Path("/topic")
	public String sendMessage2() {
		jmsContext.createProducer().send(topic, "Topic Hello");
		return "OK";
	}

	
}
