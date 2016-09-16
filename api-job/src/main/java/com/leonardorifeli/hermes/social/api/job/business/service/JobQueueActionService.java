package com.leonardorifeli.hermes.social.api.job.business.service;

import java.util.Map;

import com.leonardorifeli.hermes.social.api.job.business.service.GithubStartImport;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubImportJobQueueEnum;

public class JobQueueActionService {
	
	private Map message;
	
	private GithubStartJobQueueEnum jobQueueStartConfig;
	
	private GithubImportJobQueueEnum jobQueueImportConfig;
	
	public JobQueueActionService(Map message) {
		this.message = message;
	}
	
	public void start() {
		if(this.message.get("queueName") == jobQueueStartConfig.getQueueName()) {
			this.startGithubImportByUsername(this.message.get("username"));
		}
		
		if(this.message.get("queueName") == jobQueueImportConfig.getQueueName()) {
			System.out.println("Eu iniciei "+this.message.get("username"));
		}
	}
	
	private void startGithubImportByUsername(Object username) {
		System.out.println("haha "+ username);
	}
	
}