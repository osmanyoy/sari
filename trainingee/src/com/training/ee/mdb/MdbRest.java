package com.training.ee.mdb;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/mdb")
public class MdbRest {

	@Inject
	private JMSContext jmsContext;

	@Resource(lookup = "java:/jms/queue/JMSMyQueue")
	private Queue queue;

	@Resource(lookup = "java:/jms/queue/JMSMyTopic")
	private Topic topic;

	@GET
	public String sendMessage() {

		this.jmsContext.createProducer()
		               .send(this.queue,
		                     "hello");
		this.jmsContext.createProducer()
		               .send(this.topic,
		                     "topic hello");

		return "OK";
	}
}
