package com.aurea.trial.config;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class MqConfig {

    private static final String REPOSITORY_VERIFICATION_QUEUE = "repositorybox";

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(REPOSITORY_VERIFICATION_QUEUE);
    }

}
