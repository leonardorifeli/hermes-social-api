package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.service.JobQueueService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import org.json.JSONObject;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class ConsumerMessageService extends JobQueueService implements Runnable, Consumer {
	
	private String queueName;
	
	private List<String> consumerTag = new ArrayList<String>();
	
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}
	
	private JobQueueActionService getJobQueueActionService(JSONObject message) {
		return new JobQueueActionService(message);
	}
	
	public void run() {
		try {
			this.getChannel().basicConsume(this.queueName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void handleConsumeOk(String consumerTag) {
		this.consumerTag.add(consumerTag);	
	}

	public void handleDelivery(String consumerTag, Envelope env, BasicProperties props, byte[] body) throws IOException {
		String message = new String(body, "UTF-8");

		JSONObject messageSend = new JSONObject("{" + message + "}");

        System.out.println(messageSend.toString());

		JobQueueActionService jobQueueAction = this.getJobQueueActionService(messageSend);

		jobQueueAction.start();
	}

	public void handleCancel(String consumerTag) {}
	public void handleCancelOk(String consumerTag) {}
	public void handleRecoverOk(String consumerTag) {}
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
	
}