package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.service.JobQueueService;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class SendMessageService extends JobQueueService {

    private void queueDeclare(String queueName, Channel channel) throws IOException, TimeoutException {
        channel.queueDeclare(queueName, false, false, false, null);
    }
    
    private void publishMessage(Channel channel, String message, String queueName) throws IOException, TimeoutException {
    	channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
    }
    
    public void sendMessage(String message, String queueName) throws IOException, TimeoutException {
    	Channel channel = this.getChannel();
        
        this.queueDeclare(queueName, channel);
        this.publishMessage(channel, message, queueName);
    }
   
}