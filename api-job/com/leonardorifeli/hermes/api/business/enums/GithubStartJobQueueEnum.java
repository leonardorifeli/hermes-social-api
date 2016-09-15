package com.leonardorifeli.hermes.api.business.enums;

public abstract class GithubStartJobQueueEnum {

	private final static String QUEUE_NAME = "github_start";

    public static String getQueueName() {
    	return QUEUE_NAME;
    }

}