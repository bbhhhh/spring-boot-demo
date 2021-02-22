package com.example.springbootdemo;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
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
        url = p.getProperty("spring.activemq.broker-url");
        nbifileQueue = p.getProperty("activemq.queue.nbifile");
        logger.info("url={}", url);
        logger.info("queue={}", nbifileQueue);
        CachingConnectionFactory connFactory = null;
        try {
            Context ctx = null;
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL, url);
            try {
                ctx = new InitialContext(props);
            } catch (NamingException e) {
                logger.error(e.getMessage(), e);
                System.exit(1);
            }
            connFactory = new CachingConnectionFactory();
            connFactory.setTargetConnectionFactory((ConnectionFactory) ctx.lookup("ConnectionFactory"));

        } catch (NamingException e) {
            logger.error(e.getMessage(), e);
            System.exit(1);
        }
        jmsTemplate = new JmsTemplate(connFactory);

    }

    @Test
    public void testSendMessage() throws InterruptedException {
        Map map = new HashMap();
        map.put("name", "first");
        if (jmsTemplate == null) {
            System.err.println("jmsTemplate is null");
            return;
        }

        logger.info("before sending.");
        for (int i = 0; i < 10; i++) {
            jmsTemplate.convertAndSend(nbifileQueue, "hello");
//            jmsTemplate.convertAndSend(nbifileQueue, "message without selector", postProcessor -> {
//                postProcessor.setStringProperty("selector", (String) map.get("selector"));
//                return postProcessor;
//            });
//            map.put("selector", "1");
//            jmsTemplate.convertAndSend(nbifileQueue, "message has selector", postProcessor -> {
//                postProcessor.setStringProperty("selector", (String) map.get("selector"));
//                return postProcessor;
//            });
//            jmsTemplate.convertAndSend("nbi_result_queue", "message has selector22222", postProcessor -> {
//                postProcessor.setStringProperty("selector", (String) map.get("selector"));
//                return postProcessor;
//            });
            //TimeUnit.SECONDS.sleep(3);
        }
        logger.info("after sent.");
//        map.put("name", "second");
//        producer.sendMessageToSecondAMQ(config.getNbifileQueue(), "send to second", map);
    }

}
