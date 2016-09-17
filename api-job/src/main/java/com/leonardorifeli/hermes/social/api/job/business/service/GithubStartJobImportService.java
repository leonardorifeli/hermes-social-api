package com.leonardorifeli.hermes.social.api.job.business.service;

import java.sql.Clob;
import java.util.HashMap;
import java.util.Map;

import com.leonardorifeli.hermes.social.api.job.business.service.GithubSendMessageService;
import com.leonardorifeli.hermes.social.api.custom.business.enums.GithubImportJobQueueEnum;
import com.leonardorifeli.hermes.social.api.core.business.service.UrlRequestService;

public class GithubStartJobImportService {

	private String username;

    private UrlRequestService urlRequestService;
	
	private GithubImportJobQueueEnum jobQueueImportConfig;
	
	private GithubSendMessageService githubSendMessageService;

    private String urlUser = "https://api.github.com/users/:username";

    private String urlRepository = "https://api.github.com/users/:username/repos";

	public GithubStartJobImportService(String username) {
		this.username = username;
		this.githubSendMessageService = new GithubSendMessageService();
	}
	
	public void start() {
	    String userJson = this.getUsernameInJson();
        this.githubSendMessageService.addParam("userInformation", userJson);

        String repositoriesJson = this.getRepositoryInJson();
        this.githubSendMessageService.addParam("repositories", repositoriesJson);

        this.githubSendMessageService.start(this.username, "github", jobQueueImportConfig.getQueueName());
	}

	private String getUsernameInJson() {
        return urlRequestService.getJsonByUrl(this.urlUser.replace(":username", this.username));
    }

    private String getRepositoryInJson() {
        return urlRequestService.getJsonByUrl(this.urlRepository.replace(":username", this.username));
    }
	
}