package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.job.business.service.SendMessageService;

import javax.inject.Inject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.simple.JSONObject;

public class GithubStartMessageService {

	private SendMessageService jobSendMessageService;
	
	private GithubStartJobQueueEnum jobQueueConfig;
	
	public GithubStartMessageService() {
		this.jobSendMessageService = new SendMessageService();
	}

	public void start(String username) {
		try {
			System.out.println("chegou aqui.");
			this.jobSendMessageService.sendMessage(this.getMessageByUsername(username), jobQueueConfig.getQueueName());
			System.out.println("saiu.");
		} catch (IOException e) {

		} catch (TimeoutException e) {

		}
	}

	private String getMessageByUsername(String username) {
		JSONObject message = new JSONObject();

		message.put("username", username);
		message.put("state", "start");

		return message.toString();
	}

}