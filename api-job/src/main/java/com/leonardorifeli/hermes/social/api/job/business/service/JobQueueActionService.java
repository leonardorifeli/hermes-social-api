package com.leonardorifeli.hermes.social.api.job.business.service;

import org.json.JSONObject;

import com.leonardorifeli.hermes.social.api.job.business.service.GithubStartImportService;
import com.leonardorifeli.hermes.social.api.job.business.service.GithubStartJobImportService;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubStartJobQueueEnum;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubImportJobQueueEnum;

public class JobQueueActionService {
	
	private JSONObject message;
	
	private GithubStartJobQueueEnum jobQueueStartConfig;
	
	private GithubImportJobQueueEnum jobQueueImportConfig;
	
	public JobQueueActionService(JSONObject message) {
		this.message = message;
	}
	
	public void start() {
		if(this.message.getString("queueName").equals(jobQueueStartConfig.getQueueName())) {
			this.startGithubSendJobByUsername(this.message);
		}

		if(this.message.get("queueName").equals(jobQueueImportConfig.getQueueName())) {
            this.startGithubImportJobByUsername(this.message);
		}
	}
	
	private void startGithubSendJobByUsername(JSONObject message) {
        GithubStartJobImportService startGithub = new GithubStartJobImportService(message.getString("username"));
		startGithub.start();
	}

    private void startGithubImportJobByUsername(JSONObject message) {
        GithubStartImportService startGithub = new GithubStartImportService(message);
        startGithub.start();
    }
	
}