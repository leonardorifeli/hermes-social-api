package com.leonardorifeli.hermes.social.api.job.business.service;

import com.leonardorifeli.hermes.social.api.job.business.enums.RabbitInfoConfigurationEnum;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class JobQueueService {
	
    private RabbitInfoConfigurationEnum rabbitConf;
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Channel channel;

    private RabbitInfoConfigurationEnum getRabbitConf() {
        return this.rabbitConf;
    }

    public ConnectionFactory getConnectionFactory() {
        if(this.connectionFactory != null) {
            return this.connectionFactory;
        }

        this.connectionFactory = new ConnectionFactory();
        this.setConnectionSecurityInformation(this.connectionFactory);

        return this.connectionFactory;
    }

    private ConnectionFactory setConnectionSecurityInformation(ConnectionFactory factory) {
        factory.setHost(this.getRabbitConf().getServer());
        factory.setUsername(this.getRabbitConf().getUsername());
        factory.setPort(this.getRabbitConf().getPort());
        factory.setPassword(this.getRabbitConf().getPassword());
 
        return factory;
    }

    public Connection getConnection() throws IOException, TimeoutException {
        if(this.connection != null) {
            return this.connection;
        }
        
        this.connection = this.getConnectionFactory().newConnection();

        return this.connection;
    }

    public Channel getChannel() throws IOException, TimeoutException {
        if(this.channel !=  null) {
            return this.channel;
        }

        this.channel = this.getConnection().createChannel();

        return this.channel;
    }
    
    public void connectionClose() throws IOException, TimeoutException {
    	this.getConnection().close();
    }
    
    public void channelClose() throws IOException, TimeoutException {
    	this.getChannel().close();
    }
    
}