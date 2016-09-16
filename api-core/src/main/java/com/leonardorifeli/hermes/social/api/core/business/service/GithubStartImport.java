package com.leonardorifeli.hermes.social.api.core.business.service;

import java.util.HashMap;
import java.util.Map;

import com.leonardorifeli.hermes.social.api.job.business.enums.GithubImportJobQueueEnum;

public class GithubStartImport {
	
	private String username;
	
	private GithubImportJobQueueEnum jobQueueImportConfig;
	
	public GithubStartImport() {
		this.githubSendMessageService = new GithubSendMessageService();
	}
	
	public void start() {
		for (int i = 0; i < 10; i++) {
			HashMap value = new HashMap();
			value.put("name", "teste de repo");
			this.githubSendMessageService.addParam("repository", value);
			
			this.githubSendMessageService.start(this.username, "import", jobQueueImportConfig.getQueueName());
		}
	}
	
	private void sendMessage() {
		this.githubSendMessageService.start(this.username, "import", jobQueueImportConfig.getQueueName());
	}
	
}