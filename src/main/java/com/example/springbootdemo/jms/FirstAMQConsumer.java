package com.example.springbootdemo.jms;


import javax.jms.JMSException;
import javax.jms.TextMessage;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Project: nbifile
 * @Author : haihuab
 * @Date : 2020/6/12 10:28
 * @Description: TODO
 */

@Component
public class FirstAMQConsumer {
    private static final Logger logger = LoggerFactory.getLogger(FirstAMQConsumer.class);

    @JmsListener(destination = "${activemq.queue.nbifile}", containerFactory = "firstAMQListenerContainerFactory")
    public void processMessage(TextMessage message) {
        String json = "";
        Map<String, String> propertyMap = new HashMap();
        try {
            json = message.getText();

            Enumeration et = message.getPropertyNames();
            while (et.hasMoreElements()) {
                String propertyName = et.nextElement() + "";
                propertyMap.put(propertyName, message.getStringProperty(propertyName));
            }
            logger.info("first amq received msg payload={}", json);
            logger.info("first amq received msg properties={}", propertyMap);
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
        }
    }


}
