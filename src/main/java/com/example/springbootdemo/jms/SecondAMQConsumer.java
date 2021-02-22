package com.example.springbootdemo.jms;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Project: nbifile
 * @Author : haihuab
 * @Date : 2020/6/15 11:22
 * @Description: TODO
 */


@Component
public class SecondAMQConsumer {
    private static final Logger logger = LoggerFactory.getLogger(SecondAMQConsumer.class);


//    @JmsListener(destination = "nbi_result_queue", containerFactory = "firstAMQListenerContainerFactory")
//    public void processMessage(TextMessage message) {
//        String json = "";
//        Map<String, String> propertyMap = new HashMap();
//        try {
//            json = message.getText();
//
//            Enumeration et = message.getPropertyNames();
//            while (et.hasMoreElements()) {
//                String propertyName = et.nextElement() + "";
//                propertyMap.put(propertyName, message.getStringProperty(propertyName));
//            }
//            logger.info("second amq received msg payload={}", json);
//            logger.info("second amq received msg properties={}", propertyMap);
//        } catch (JMSException e) {
//            logger.error(e.getMessage(), e);
//        }
//    }
}
