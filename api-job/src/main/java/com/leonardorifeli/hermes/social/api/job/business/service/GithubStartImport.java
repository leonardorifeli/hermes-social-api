package com.leonardorifeli.hermes.social.api.job.business.service;

import java.util.HashMap;
import java.util.Map;

import com.leonardorifeli.hermes.social.api.job.business.service.GithubSendMessageService;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubImportJobQueueEnum;

public class GithubStartImport {
	
	private String username;
	
	private GithubImportJobQueueEnum jobQueueImportConfig;
	
	private GithubSendMessageService githubSendMessageService;
	
	public GithubStartImport() {
		this.githubSendMessageService = new GithubSendMessageService();
	}
	
	public void start() {
		for (int i = 0; i < 100; i++) {
			this.githubSendMessageService.addParam("repository", "hahaha");
			this.githubSendMessageService.addParam("name", "hahaha name");
			
			this.githubSendMessageService.start(this.username, "import", jobQueueImportConfig.getQueueName());
		}
	}
	
	private void sendMessage() {
		this.githubSendMessageService.start(this.username, "import", jobQueueImportConfig.getQueueName());
	}
	
}