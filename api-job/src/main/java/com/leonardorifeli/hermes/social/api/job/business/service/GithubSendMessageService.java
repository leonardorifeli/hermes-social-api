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

import org.json.simple.JSONObject;

public class GithubSendMessageService {

	private SendMessageService jobSendMessageService;
	
	private GithubConsumerMessageService githubConsumerMessageService;
	
	List<ParamProperty> params = new ArrayList<ParamProperty>();
	
	public void addParam(String key, String value) {
		ParamProperty param = new ParamProperty();
		param.setKey(key);
		param.setValue(value);
	}
	
	public GithubSendMessageService() {
		this.githubConsumerMessageService = new GithubConsumerMessageService();
		this.jobSendMessageService = new SendMessageService();
	}
	
	public void start(String username, String action, String queueName) {
		try {
			this.githubConsumerMessageService.start(queueName);
			this.jobSendMessageService.sendMessage(this.getMessageByUsername(username, action, queueName), queueName);
		} catch (IOException e) {
			
		} catch (TimeoutException e) {
			
		}
	}

	private HashMap getMessageByUsername(String username, String action, String queueName) {
		HashMap message = new HashMap();
		message.put("username", username);
		message.put("queueName", queueName);
		message.put("action", action);
		
		this.checkParams(message);

		return message;
	}
	
	private void checkParams(HashMap message) {
		if(this.params.size() > 0) {
			for (int i = 0; i < this.params.size(); i++) {
				String value = this.params.get(i).getValue();
				String key = this.params.get(i).getKey();
				
				message.put(key, value);
			}
		}
	}

}