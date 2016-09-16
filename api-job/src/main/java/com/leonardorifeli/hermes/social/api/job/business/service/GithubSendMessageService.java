package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.job.business.service.GithubConsumerMessageService;
import com.leonardorifeli.hermes.social.api.job.business.service.SendMessageService;

import javax.inject.Inject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.simple.JSONObject;

public class GithubSendMessageService {

	private SendMessageService jobSendMessageService;
	
	private GithubConsumerMessageService githubConsumerMessageService;
	
	private GithubStartJobQueueEnum jobQueueConfig;
	
	public GithubSendMessageService() {
		this.jobSendMessageService = new SendMessageService();
		this.githubConsumerMessageService = new GithubConsumerMessageService();
	}
	
	public void start(String username) {
		try {
			this.githubConsumerMessageService.start(jobQueueConfig.getQueueName());
			this.jobSendMessageService.sendMessage(this.getMessageByUsername(username), jobQueueConfig.getQueueName());
		} catch (IOException e) {
			
		} catch (TimeoutException e) {
			
		}
	}

	private String getMessageByUsername(String username) {
		JSONObject message = new JSONObject();

		message.put("username", username);
		message.put("action", "start");

		return message.toString();
	}

}