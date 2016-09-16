package com.leonardorifeli.hermes.social.api.job.business.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class GithubConsumerMessageService {
	
	private ConsumerMessageService consumerMessageservice;
	
	public GithubConsumerMessageService() {
		this.consumerMessageservice = new ConsumerMessageService();
	}
	
	public void start(String queueName) {
		this.consumerMessageservice.setQueueName(queueName);
		this.startThread(this.consumerMessageservice);
	}
	
	private void startThread(ConsumerMessageService consumerMessageservice) {
		Thread consumerThread = new Thread(consumerMessageservice);
		consumerThread.start();
	}
	
}