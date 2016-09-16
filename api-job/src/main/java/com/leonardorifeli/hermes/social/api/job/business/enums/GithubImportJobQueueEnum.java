package com.leonardorifeli.hermes.social.api.job.business.enums;

public abstract class GithubImportJobQueueEnum {

	private final static String QUEUE_NAME = "github_import";

    public static String getQueueName() {
    	return QUEUE_NAME;
    }

}