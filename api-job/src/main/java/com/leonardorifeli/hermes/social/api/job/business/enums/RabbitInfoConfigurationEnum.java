package com.leonardorifeli.hermes.social.api.job.business.enums;

public abstract class RabbitInfoConfigurationEnum {

	private final static String SERVER = "127.0.0.1";
	
    private final static String USERNAME = "guest";
    
    private final static String PASSWORD = "guest";
    
    private final static Integer PORT = 5672;

    public static String getServer() {
    	return SERVER;
    }

    public static String getUsername() {
    	return USERNAME;
    }

    public static String getPassword() {
    	return PASSWORD;
    }

    public static Integer getPort() {
    	return PORT;
    }

}