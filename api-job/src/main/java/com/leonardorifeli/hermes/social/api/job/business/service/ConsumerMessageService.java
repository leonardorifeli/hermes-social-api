package com.leonardorifeli.hermes.social.api.job.business.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class ConsumerMessageService implements Runnable, Consumer {
	
	private String queueName;
	
	public ConsumerMessageService(String queueName) {
		this.queueName = queueName;
	}
	
	public void run() {
		try {
			channel.basicConsume(endPointName, true,this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");		
	}

	public void handleDelivery(String consumerTag, Envelope env,
			BasicProperties props, byte[] body) throws IOException {
		Map map = (HashMap)SerializationUtils.deserialize(body);
	    System.out.println("Message Number "+ map.get("message number") + " received.");
		
	}

	public void handleCancel(String consumerTag) {}
	public void handleCancelOk(String consumerTag) {}
	public void handleRecoverOk(String consumerTag) {}
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
}