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
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 * @Project: nbifile
 * @Author : haihuab
 * @Date : 2020/6/12 11:01
 * @Description: TODO
 */

@EnableJms
@Configuration
public class ActiveMQConfig {
    private static final Logger logger = LoggerFactory.getLogger(ActiveMQConfig.class);

    @Value("${activemq.queue.nbifile}")
    public String nbifileQueue;


    //    @ConditionalOnProperty(prefix = "spring.activemq.first", name = "broker-url")
//    @Bean(name = "firstAMQConnectionFactory")
//    @Primary
//    public ConnectionFactory firstAMQConnectionFactory(
//            @Value("${spring.activemq.first.broker-url}") String url
//    ) {
//        logger.info("create first AMQ connection factory.");
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//        return connectionFactory;
//    }
//
//    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
//    @Bean(name = "secondAMQConnectionFactory")
//    public ConnectionFactory secondAMQConnectionFactory(
//            @Value("${spring.activemq.second.broker-url}") String url
//    ) {
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
//        return connectionFactory;
//    }
//
//
//    @ConditionalOnProperty(prefix = "spring.activemq.first", name = "broker-url")
//    @Bean(name = "firstAMQTemplate")
//    @Primary
//    public JmsTemplate firstAMQTemplate(
//            @Qualifier("firstAMQConnectionFactory") ConnectionFactory connectionFactory) {
//        logger.info("create first AMQ template");
//        JmsTemplate northTemplate = new JmsTemplate(connectionFactory);
//        return northTemplate;
//    }
//
//    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
//    @Bean(name = "secondAMQTemplate")
//    public JmsTemplate secondAMQTemplate(
//            @Qualifier("secondAMQConnectionFactory") ConnectionFactory connectionFactory) {
//        JmsTemplate southTemplate = new JmsTemplate(connectionFactory);
//        return southTemplate;
//    }
//
//    @ConditionalOnProperty(prefix = "spring.activemq.first", name = "broker-url")
    @Bean
    public JmsListenerContainerFactory<?> jmsQueueListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                           DefaultJmsListenerContainerFactoryConfigurer configurer) {
        logger.info("create firstJmsListenerContainerFactory");
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, connectionFactory);
        containerFactory.setErrorHandler(e -> logger.error("an jms error has occurred in jmsQueue.", e));
        containerFactory.setPubSubDomain(false);
        return containerFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsTopicListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                           DefaultJmsListenerContainerFactoryConfigurer configurer) {
        logger.info("create firstJmsListenerContainerFactory");
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, connectionFactory);
        containerFactory.setErrorHandler(e -> logger.error("an jms error has occurred in jmsTopic.", e));
        containerFactory.setPubSubDomain(true);
        return containerFactory;
    }

//
//    @ConditionalOnProperty(prefix = "spring.activemq.second", name = "broker-url")
//    @Bean(name = "secondAMQListenerContainerFactory")
//    public JmsListenerContainerFactory<?> secondJmsListenerContainerFactory(
//            @Qualifier("secondAMQConnectionFactory") ConnectionFactory connectionFactory,
//            DefaultJmsListenerContainerFactoryConfigurer configurer) {
//        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
//        configurer.configure(containerFactory, connectionFactory);
//        return containerFactory;
//    }


}
