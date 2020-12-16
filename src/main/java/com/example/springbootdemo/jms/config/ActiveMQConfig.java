package com.example.springbootdemo.jms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Project: nbifile
 * @Author : haihuab
 * @Date : 2020/6/12 11:01
 * @Description: TODO
 */
@Configuration
public class ActiveMQConfig {
    private static final Logger logger = LoggerFactory.getLogger(ActiveMQConfig.class);

    @Value("${activemq.queue.nbifile}")
    private String nbifileQueue;

    public String getNbifileQueue() {
        return nbifileQueue;
    }


    @Bean(name = "firstAMQConnectionFactory")
    @Primary
    public ConnectionFactory firstAMQConnectionFactory(
            @Value("${spring.activemq.first.broker-url}") String url
    ) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        return connectionFactory;
    }

    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
    @Bean(name = "secondAMQConnectionFactory")
    public ConnectionFactory secondAMQConnectionFactory(
            @Value("${spring.activemq.second.broker-url}") String url
    ) {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        return connectionFactory;
    }


    @Bean(name = "firstAMQTemplate")
    @Primary
    public JmsTemplate firstAMQTemplate(
            @Qualifier("firstAMQConnectionFactory") ConnectionFactory connectionFactory) {
        JmsTemplate northTemplate = new JmsTemplate(connectionFactory);
        return northTemplate;
    }

    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
    @Bean(name = "secondAMQTemplate")
    public JmsTemplate secondAMQTemplate(
            @Qualifier("secondAMQConnectionFactory") ConnectionFactory connectionFactory) {
        JmsTemplate southTemplate = new JmsTemplate(connectionFactory);
        return southTemplate;
    }

    @Bean(name = "firstAMQListenerContainerFactory")
    @Primary
    public JmsListenerContainerFactory<?> firstJmsListenerContainerFactory(
            @Qualifier("firstAMQConnectionFactory") ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, connectionFactory);
        return containerFactory;
    }

    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
    @Bean(name = "secondAMQListenerContainerFactory")
    public JmsListenerContainerFactory<?> secondJmsListenerContainerFactory(
            @Qualifier("secondAMQConnectionFactory") ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, connectionFactory);
        return containerFactory;
    }


}
