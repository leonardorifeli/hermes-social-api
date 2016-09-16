package com.leonardorifeli.hermes.social.api.job.business.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class GithubConsumerMessageService {
	
	public void start(String queueName) {
		
	}
	
	private void startThread(String queueName, GithubConsumerMessageService githubConsumerMessageService) {
		this.setQueueName(queueName);
		Thread consumerThread = new Thread(githubConsumerMessageService);
		consumerThread.start();
	}
	
}