package com.example.springbootdemo.jms;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @Project: nbifile
 * @Author : haihuab
 * @Date : 2020/6/12 10:44
 * @Description: TODO
 */
@Component
public class AMQProducer {
    private static final Logger logger = LoggerFactory.getLogger(AMQProducer.class);

    @Autowired
    private JmsTemplate firstAMQTemplate;

//    @Autowired(required = false)
//    @Qualifier("secondAMQTemplate")
//    private JmsTemplate secondAMQTemplate;

    public void sendMessageToFirstAMQ(String queueName, String json, Map map) {

        this.firstAMQTemplate.convertAndSend(queueName, json, postConvertedMessage -> {
            if (map != null) {
                postConvertedMessage.setStringProperty("selector", (String) map.get("selector"));
            }
            return postConvertedMessage;
        });

    }
    

//    public void sendMessageToSecondAMQ(String queueName, String json, Map map) {
//        if (this.secondAMQTemplate == null) {
//            logger.warn("No secondAMQ broker-url found, can't send message to second AMQ.");
//            return;
//        }
//        this.secondAMQTemplate.convertAndSend(queueName, json);
//    }


}
