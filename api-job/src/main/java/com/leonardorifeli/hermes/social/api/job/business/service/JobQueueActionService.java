package com.leonardorifeli.hermes.social.api.job.business.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.leonardorifeli.hermes.social.api.job.business.service.GithubStartImport;
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
			this.startGithubImportByUsername(this.message);
		}

		if(this.message.get("queueName").equals(jobQueueImportConfig.getQueueName())) {
			System.out.println("Importando do github "+this.message.toString());
		}
	}
	
	private void startGithubImportByUsername(JSONObject message) {
		GithubStartImport startGithub = new GithubStartImport(message.getString("username"));
		startGithub.start();
	}
	
}