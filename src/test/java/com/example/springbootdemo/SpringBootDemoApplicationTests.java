package com.example.springbootdemo;

import javax.jms.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class SpringBootDemoApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootDemoApplicationTests.class);

    private static String url;

    private static String nbifileQueue;

    private static JmsTemplate jmsTemplate;

    @BeforeClass
    public static void setup() throws IOException {
        logger.info("@BeforeClass running...");

        InputStream in = SpringBootDemoApplicationTests.class.getClassLoader().getResourceAsStream("application.properties");

        Properties p = new Properties();
        p.load(in);
        in.close();
        url = p.getProperty("spring.activemq.first.broker-url");
        nbifileQueue = p.getProperty("activemq.queue.nbifile");
        logger.info("url={}", url);
        logger.info("queue={}", nbifileQueue);
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        jmsTemplate = new JmsTemplate(connectionFactory);

    }

    @Test
    public void testSendMessage() {
        Map map = new HashMap();
        map.put("name", "first");
        if (jmsTemplate == null) {
            System.err.println("jmsTemplate is null");
            return;
        }


        jmsTemplate.convertAndSend(nbifileQueue, "message without selector", postProcessor -> {
            postProcessor.setStringProperty("selector", (String) map.get("selector"));
            return postProcessor;
        });
        map.put("selector", "1");
        jmsTemplate.convertAndSend(nbifileQueue, "message has selector", postProcessor -> {
            postProcessor.setStringProperty("selector", (String) map.get("selector"));
            return postProcessor;
        });
        jmsTemplate.convertAndSend(nbifileQueue, "message has selector22222", postProcessor -> {
            postProcessor.setStringProperty("selector", (String) map.get("selector"));
            return postProcessor;
        });
//        map.put("name", "second");
//        producer.sendMessageToSecondAMQ(config.getNbifileQueue(), "send to second", map);
    }

}
