package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.api.job.business.enums.GithubStartJobQueueEnum;

public class GithubStartMessageService {
	
	@Inject
	private SendService jobSendService;
	
	private SendService getJobSendService() {
		return this.jobSendService
	}
	
	public void start(String username) {
		
	}
	
}