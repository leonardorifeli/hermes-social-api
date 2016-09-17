package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.property.ParamProperty;
import com.leonardorifeli.hermes.social.api.job.business.service.GithubConsumerMessageService;
import com.leonardorifeli.hermes.social.api.job.business.service.SendMessageService;

import javax.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

public class GithubSendMessageService {

	private SendMessageService jobSendMessageService;
	
	private GithubConsumerMessageService githubConsumerMessageService;
	
	List<ParamProperty> params = new ArrayList<ParamProperty>();
	
	public void addParam(String key, String value) {
		ParamProperty param = new ParamProperty(key, value);
		this.params.add(param);
	}
	
	public GithubSendMessageService() {
		this.githubConsumerMessageService = new GithubConsumerMessageService();
		this.jobSendMessageService = new SendMessageService();
	}
	
	public void start(String username, String action, String queueName) {
		try {
			this.githubConsumerMessageService.start(queueName);
            System.out.println("Enviando novo json: "+ this.getMessageByUsername(username, action, queueName));
			this.jobSendMessageService.sendMessage(this.getMessageByUsername(username, action, queueName), queueName);
		} catch (IOException e) {
			
		} catch (TimeoutException e) {
			
		}
	}

	private String getMessageByUsername(String username, String action, String queueName) {
		JSONObject message = new JSONObject();

		message.put("username", username);
		message.put("queueName", queueName);
		message.put("action", action);
		
		this.checkParams(message);

		return message.toString();
	}
	
	private void checkParams(JSONObject message) {
		if(this.params.size() > 0) {
			for(int i = 0; i < this.params.size(); i++) {
				String value = this.params.get(i).getValue();
				String key = this.params.get(i).getKey();
				
				message.put(key, value);
			}
		}
	}

}