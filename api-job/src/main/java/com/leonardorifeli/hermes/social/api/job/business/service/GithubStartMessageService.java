package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.job.business.service.SendMessageService;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.simple.JSONObject;

public class GithubStartMessageService {

	@Inject
	private SendMessageService jobSendMessageService;
	
	private GithubStartJobQueueEnum jobQueueConfig;

	private SendService getJobSendMessageService() {
		return this.jobSendMessageService
	}

	public void start(String username) {
		this.getJobSendMessageService().sendMessage(this.getMessageByUsername(username), jobQueueConfig.getQueueName());
	}

	private String getMessageByUsername(String username) {
		JSONObject message = new JSONObject();

		message.put("username", username);
		message.put("state", "start");

		return message.toString();
	}

}